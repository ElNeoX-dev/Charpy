import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.lang.Integer;

public class Fenetre extends JFrame implements ActionListener {

    public JPanel monConteneur1;
    public Dessin monConteneur2;
    public JPanel monConteneurMain;

    public JTextField monChamps1;
    public JTextField monChamps2;
    public JTextField monChamps3;
    public JTextField monChamps4;
    public JTextField monChamps5;
    public JTextField monChamps6;
    public JTextField monChamps7;

    public JLabel monEtiquette1;
    public JLabel monEtiquette2;
    public JLabel monEtiquette3;
    public JLabel monEtiquette4;
    public JLabel monEtiquette5;
    public JLabel monEtiquette6;
    public JLabel monEtiquette7;

    private Pendule p;
    private Eprouvette ep;
    private Timer chrono;
    public JButton majPendule;
    public JButton lancement;

    public double tempsMs = 0;

    public Fenetre(Pendule p, Eprouvette e) {
        super("Affichage des courbes");
        setSize(1800, 1000);
        setLocation(0, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.p = p;
        this.ep = e;
        chrono = new Timer(15 ,this);

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
        monEtiquette1 = new JLabel();
        monEtiquette1.setText("Affichage résultat");
        monEtiquette1.setBounds(75, 20, 260, 30);
        monConteneur1.add(monEtiquette1);

        monChamps1 = new JTextField(""); // affichage résultat
        monChamps1.setBounds(20, 60, 260, 100);
        monChamps1.setBackground(Color.white);
        monConteneur1.add(monChamps1);


        monEtiquette2 = new JLabel();
        monEtiquette2.setText("Coeff frottements");
        monEtiquette2.setBounds(20, 240, 120, 30);
        monConteneur1.add(monEtiquette2);

        monChamps2 = new JTextField(""); // coeff frottements
        monChamps2.setBounds(20, 280, 120, 60);
        monChamps2.setBackground(Color.white);
        monConteneur1.add(monChamps2);


        monEtiquette3 = new JLabel();
        monEtiquette3.setText("Taille tige");
        monEtiquette3.setBounds(160, 240, 120, 30);
        monConteneur1.add(monEtiquette3);

        monChamps3 = new JTextField(""); // taille tige
        monChamps3.setBounds(160, 280, 120, 60);
        monChamps3.setBackground(Color.white);
        monConteneur1.add(monChamps3);


        monEtiquette4 = new JLabel();
        monEtiquette4.setText("Angle initial");
        monEtiquette4.setBounds(20, 360, 120, 30);
        monConteneur1.add(monEtiquette4);

        monChamps4 = new JTextField(""); // hauteur départ
        monChamps4.setBounds(20, 400, 120, 60);
        monChamps4.setBackground(Color.white);
        monConteneur1.add(monChamps4);


        monEtiquette5 = new JLabel();
        monEtiquette5.setText("masse marteau");
        monEtiquette5.setBounds(160, 360, 120, 30);
        monConteneur1.add(monEtiquette5);

        monChamps5 = new JTextField(""); // masse marteau
        monChamps5.setBounds(160, 400, 120, 60);
        monChamps5.setBackground(Color.white);
        monConteneur1.add(monChamps5);


        monEtiquette6 = new JLabel();
        monEtiquette6.setText("Vitesse initiale");
        monEtiquette6.setBounds(20, 480, 120, 30);
        monConteneur1.add(monEtiquette6);

        monChamps6 = new JTextField(""); // Vinit
        monChamps6.setBounds(20, 520, 120, 60);
        monChamps6.setBackground(Color.white);
        monConteneur1.add(monChamps6);


        monEtiquette7 = new JLabel();
        monEtiquette7.setText("Epaisseur éprouvette");
        monEtiquette7.setBounds(160, 480, 120, 30);
        monConteneur1.add(monEtiquette7);

        monChamps7 = new JTextField(""); // épaisseur éprouvette
        monChamps7.setBounds(160, 520, 120, 60);
        monChamps7.setBackground(Color.white);
        monConteneur1.add(monChamps7);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == chrono && lancement.getBackground() == Color.green) {
            tempsMs += chrono.getDelay() / 1000.0; 
            p.majPos(tempsMs);
            if(p.testCollision(ep)) {
                ep.estVivant = false;
            }
            monConteneur2.maj(p, ep);
            repaint();
        }

        if(e.getSource() == lancement) {
            if(lancement.getBackground() == Color.red) {
                lancement.setBackground(Color.green);
                chrono.start();
            } else {
                lancement.setBackground(Color.red);
                chrono.stop();
            }
            

        }

        if(e.getSource() == majPendule) {
            chrono.stop();
            this.p = new Pendule(Integer.parseInt(monChamps5.getText()), Integer.parseInt(monChamps3.getText()),
            Double.parseDouble(monChamps4.getText()), Integer.parseInt(monChamps6.getText()));
            this.ep.hauteur = Integer.parseInt(monChamps3.getText());
            monConteneur2.maj(p, ep);
            repaint();
        }
    }
}