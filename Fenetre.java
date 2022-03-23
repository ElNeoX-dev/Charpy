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
        monConteneur1.setBackground(Color.green);
        monConteneur2.setBounds(300, 0, 1500, 1000);// JPanel esapce dessin = new Dessin (pendule,eprouvette)
        monConteneur2.setBackground(Color.white);
        monConteneurMain.add(monConteneur1);
        monConteneurMain.add(monConteneur2);
        monConteneurMain.setBackground(Color.yellow);
        this.add(monConteneurMain);

        // boutons
        monBouton1 = new JButton("Lancer l'animation");
        monBouton1.setBounds(20, 100, 150, 40);
        monBouton1.setBackground(Color.white);
        monConteneur1.add(monBouton1);

        // TextField
        monChamps1 = new JTextField(""); // affichage résultat
        monChamps1.setBounds(20, 20, 260, 100);
        monChamps1.setBackground(Color.white);
        monConteneur1.add(monChamps1);
        monChamps2 = new JTextField("valeur frottements"); // coeff frottements
        monChamps2.setBounds(20, 200, 120, 60);
        monChamps2.setBackground(Color.white);
        monConteneur1.add(monChamps2);
        monChamps3 = new JTextField("taille tige"); // taille tige
        monChamps3.setBounds(160, 200, 120, 60);
        monChamps3.setBackground(Color.white);
        monConteneur1.add(monChamps3);
        monChamps4 = new JTextField("hauteur départ"); // hauteur départ
        monChamps4.setBounds(20, 280, 120, 60);
        monChamps4.setBackground(Color.white);
        monConteneur1.add(monChamps4);
        monChamps5 = new JTextField("Masse marteau"); // masse marteau
        monChamps5.setBounds(160, 280, 120, 60);
        monChamps5.setBackground(Color.white);
        monConteneur1.add(monChamps5);
        monChamps6 = new JTextField("vitesse initiale"); // Vinit
        monChamps6.setBounds(20, 340, 120, 60);
        monChamps6.setBackground(Color.white);
        monConteneur1.add(monChamps6);

        setVisible(true);
    }
}