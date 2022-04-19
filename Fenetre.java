import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.lang.Integer;
import java.util.ArrayList;

public class Fenetre extends JFrame implements ActionListener {

    public JPanel monConteneur1;
    public Dessin monConteneur2;
    public JPanel monConteneurMain;

    public JTextField TxtaffichageResultat;
    public JTextField TxtCoefFrottements;
    public JTextField TxtTailleTige;
    public JTextField TxtAngleInitial;
    public JTextField TxtMasseMarteau;
    public JTextField TxtVinit;
    public JTextField TxtEpaisseurEprouvette;

    public JLabel affichageResultat;
    public JLabel coeffFrottements;
    public JLabel tailleTige;
    public JLabel angleInitial;
    public JLabel masseMarteau;
    public JLabel vitesseInitiale;
    public JLabel epaisseurEprouvette;

    private Pendule p;
    private Eprouvette ep;
    private Timer chrono;
    public JButton majPendule;
    public JButton lancement;

    public JComboBox<String> choixMat;
    public Eprouvette eprouvette;
    public BaseDonneeMateriaux BD;

    public JSlider CoefFrottements;

    public double tempsMs = 0;

    public Fenetre() {
        super("Affichage des courbes");
        setSize(1800, 1000);
        setLocation(0, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        chrono = new Timer(1, this);
	
    
        BD=new BaseDonneeMateriaux();
        String[] listeMat = new String[BD.maListeMateriau.size()];
        for (int i = 0; i < listeMat.length; i++) {
            listeMat[i] = BD.maListeMateriau.get(i).Nom;
        }

        choixMat = new JComboBox<String>(listeMat);
        choixMat.setBounds(20, 630, 120, 50);


        this.ep = new Eprouvette(BD.maListeMateriau.get(0), 100, 500);
        this.p = new Pendule(1, 500, 0, 0, 0, ep, this);

        // conteneurs
        monConteneur1 = new JPanel();
        monConteneur1.setLayout(null);

        monConteneur2 = new Dessin(p, ep);
        monConteneur2.setLayout(null);

        monConteneurMain = new JPanel();
        monConteneurMain.setLayout(null);

        monConteneur1.setBounds(0, 0, 300, 1000);
        monConteneur1.setBackground(Color.lightGray);

        monConteneur2.setBounds(300, 0, 1500, 1000);// JPanel esapce dessin = new Dessin (pendule,eprouvette)
        monConteneur2.setBackground(Color.white);

        monConteneurMain.add(monConteneur1);
        monConteneurMain.add(monConteneur2);
        this.add(monConteneurMain);


        // boutons
        lancement = new JButton("Lancer");
        lancement.setBounds(20, 180, 120, 40);
        lancement.setBackground(Color.red);
        lancement.addActionListener(this);
        monConteneur1.add(lancement);

        // boutons de maj de l'affichage
        majPendule = new JButton("Reset");
        majPendule.setBounds(150, 180, 120, 40);
        majPendule.setBackground(Color.red);
        majPendule.addActionListener(this);
        monConteneur1.add(majPendule);

        // TextField + étiquettes
        affichageResultat = new JLabel();
        affichageResultat.setText("Affichage résultat");
        affichageResultat.setBounds(75, 20, 260, 30);
        monConteneur1.add(affichageResultat);

        TxtaffichageResultat = new JTextField(""); // affichage résultat
        TxtaffichageResultat.setBounds(20, 60, 260, 100);
        TxtaffichageResultat.setBackground(Color.white);
        monConteneur1.add(TxtaffichageResultat);

        coeffFrottements = new JLabel();
        coeffFrottements.setText("Coeff frottements");
        coeffFrottements.setBounds(90, 240, 120, 30);
        monConteneur1.add(coeffFrottements);

        tailleTige = new JLabel();
        tailleTige.setText("Taille tige en metres");
        tailleTige.setBounds(160, 600, 120, 30);
        monConteneur1.add(tailleTige);

        TxtTailleTige = new JTextField(5); // taille tige
        TxtTailleTige.setBounds(160, 640, 120, 60);
        TxtTailleTige.setBackground(Color.white);
        monConteneur1.add(TxtTailleTige);

        angleInitial = new JLabel();
        angleInitial.setText("Angle initial en °");
        angleInitial.setBounds(20, 360, 120, 30);
        monConteneur1.add(angleInitial);

        TxtAngleInitial = new JTextField(0); // hauteur départ
        TxtAngleInitial.setBounds(20, 400, 120, 60);
        TxtAngleInitial.setBackground(Color.white);
        monConteneur1.add(TxtAngleInitial);

        masseMarteau = new JLabel();
        masseMarteau.setText("masse marteau en kg");
        masseMarteau.setBounds(160, 360, 120, 30);
        monConteneur1.add(masseMarteau);

        TxtMasseMarteau = new JTextField(1); // masse marteau
        TxtMasseMarteau.setBounds(160, 400, 120, 60);
        TxtMasseMarteau.setBackground(Color.white);
        monConteneur1.add(TxtMasseMarteau);

        vitesseInitiale = new JLabel();
        vitesseInitiale.setText("Vitesse initiale en m/s");
        vitesseInitiale.setBounds(20, 480, 120, 30);
        monConteneur1.add(vitesseInitiale);

        TxtVinit = new JTextField(0); // Vinit
        TxtVinit.setBounds(20, 520, 120, 60);
        TxtVinit.setBackground(Color.white);
        monConteneur1.add(TxtVinit);

        epaisseurEprouvette = new JLabel();
        epaisseurEprouvette.setText("Epaisseur éprouvette en cm");
        epaisseurEprouvette.setBounds(160, 480, 120, 30);
        monConteneur1.add(epaisseurEprouvette);

        TxtEpaisseurEprouvette = new JTextField(0); // épaisseur éprouvette
        TxtEpaisseurEprouvette.setBounds(160, 520, 120, 60);
        TxtEpaisseurEprouvette.setBackground(Color.white);
        monConteneur1.add(TxtEpaisseurEprouvette);

        monConteneur1.add(choixMat);
        choixMat.addActionListener(this);

        CoefFrottements = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        CoefFrottements.setBounds(20, 280, 260, 60);
        monConteneur1.add(CoefFrottements);
        CoefFrottements.setMajorTickSpacing(10);
        CoefFrottements.setMinorTickSpacing(0);
        CoefFrottements.setPaintTicks(true);
        CoefFrottements.setPaintLabels(true);


        setVisible(true);
    }

    public void setChrono(boolean etat) {
        if(etat == false) {
            chrono.stop();
        } else {
            chrono.start();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chrono && lancement.getBackground() == Color.green) {
            repaint();
        }


        if (e.getSource() == lancement) {
            if (lancement.getBackground() == Color.red) {
                lancement.setBackground(Color.green);
                chrono.start();
            } else {
                lancement.setBackground(Color.red);
                chrono.stop();
            }
        }


        if (e.getSource() == majPendule) {

            chrono.stop();

            double frottements = CoefFrottements.getValue() / 1000.0;

            this.ep = new Eprouvette(BD.maListeMateriau.get(choixMat.getSelectedIndex()), Integer.parseInt(TxtEpaisseurEprouvette.getText()),
            Integer.parseInt(TxtTailleTige.getText())*100); 
            
            p.resetPendule(Integer.parseInt(TxtMasseMarteau.getText()), Integer.parseInt(TxtTailleTige.getText()),
            Double.parseDouble(TxtAngleInitial.getText()), Double.parseDouble(TxtVinit.getText()), frottements, ep);


            monConteneur2.maj(p, ep);
            lancement.setBackground(Color.red);
            repaint();
        }
    }


    /*
     * public void degreRadian (){
     * this.angleInitial = angleInitial*Math.PI/180;
     * }
     */
}
