import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {

    public JButton monBouton1;
    public JPanel monConteneur1;
    public JPanel monConteneur2;
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

    public Fenetre() {
        super("Affichage des courbes");
        setSize(1800, 1000);
        setLocation(0, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // conteneurs
        monConteneur1 = new JPanel();
        monConteneur1.setLayout(null);
        monConteneur2 = new JPanel();
        monConteneur2.setLayout(null);
        monConteneurMain = new JPanel();
        monConteneurMain.setLayout(null);

        monConteneur1.setBounds(0, 0, 300, 1000);
        monConteneur1.setBackground(Color.lightGray);
        monConteneur2.setBounds(300, 0, 1500, 1000);// JPanel esapce dessin = new Dessin (pendule,eprouvette)
        monConteneur2.setBackground(Color.white);
        monConteneurMain.add(monConteneur1);
        monConteneurMain.add(monConteneur2);
        monConteneurMain.setBackground(Color.yellow);
        this.add(monConteneurMain);

        // boutons
        monBouton1 = new JButton("Lancer l'animation");
        monBouton1.setBounds(75, 180, 150, 40);
        monBouton1.setBackground(Color.red);
        monConteneur1.add(monBouton1);

        // TextField + étiquettes
        monEtiquette1 = new JLabel();
        monEtiquette1.setText("affichage résultat");
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
        monEtiquette3.setText("taille tige");
        monEtiquette3.setBounds(160, 240, 120, 30);
        monConteneur1.add(monEtiquette3);
        monChamps3 = new JTextField(""); // taille tige
        monChamps3.setBounds(160, 280, 120, 60);
        monChamps3.setBackground(Color.white);
        monConteneur1.add(monChamps3);
        monEtiquette4 = new JLabel();
        monEtiquette4.setText("hauteur départ");
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
}