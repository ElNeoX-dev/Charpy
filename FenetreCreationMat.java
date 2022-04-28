import java.awt.event.*;  
import java.awt.*;  
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class FenetreCreationMat extends JFrame implements ActionListener {
    
    Color couleur;
    public JPanel conteneurMain;
    public JPanel conteneurCouleur;
    public JButton boutonCreation;
    public JButton boutonChoixCouleur;
    public JLabel nom;
    public JLabel resilience;
    public JTextField txtNom;
    public JTextField txtRes;
    ArrayList<Materiau> bdMat;
    Fenetre f;
    
    public FenetreCreationMat(Fenetre f) {
        super("Création Matériau");
        setSize(330, 350);
        setLocation(500, 200);

        this.f = f;
        conteneurMain = new JPanel();
        conteneurMain.setLayout(null);

        conteneurCouleur = new JPanel();
        conteneurCouleur.setLayout(null);
        conteneurCouleur.setBackground(Color.blue);
        conteneurCouleur.setBounds(230, 150, 40, 40);
        conteneurMain.add(conteneurCouleur);

        boutonChoixCouleur = new JButton("Choisir une couleur");
        boutonChoixCouleur.setBounds(20, 150, 120, 40);
        boutonChoixCouleur.addActionListener(this);
        conteneurMain.add(boutonChoixCouleur);

        boutonCreation = new JButton("Créer !");
        boutonCreation.setBounds(105, 250, 120, 40);
        boutonCreation.addActionListener(this);
        conteneurMain.add(boutonCreation);

        nom = new JLabel("Nom : ");
        nom.setBounds(20, 10, 120, 30);
        conteneurMain.add(nom);

        resilience = new JLabel("Résilience : ");
        resilience.setBounds(190, 10, 120, 30);
        conteneurMain.add(resilience);

        txtNom = new JTextField();
        txtNom.setBounds(20, 50, 120, 60);
        conteneurMain.add(txtNom);

        txtRes = new JTextField();
        txtRes.setBounds(190, 50, 120, 60);
        conteneurMain.add(txtRes);

        this.add(conteneurMain);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boutonChoixCouleur) {
            couleur = JColorChooser.showDialog(this, "Choisissez une couleur", Color.blue);
            conteneurCouleur.setBackground(couleur);
        } else {
            creationMat();
        }

    }

    public void creationMat() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("BDMat.txt", true));
            if(verifValeur()) {
                writer.write("\r" + txtNom.getText() + "," + txtRes.getText() + "," + couleur.getRed() 
                + "," + couleur.getGreen() + "," + couleur.getBlue() + "," + couleur.getAlpha());
                f.initListeMateriau();
                JOptionPane.showMessageDialog(this, "Le matériau a bien été créé", "Opération réussie !", 2);
                this.dispose();
            }
            writer.close();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erreur dans l'écriture du fichier BDMat.txt",
            "Erreur écriture fichier", 0);
        }
    }

    public boolean verifValeur() {
        try {
            if(Double.parseDouble(txtRes.getText()) < 0) {
                JOptionPane.showMessageDialog(this, "Veuillez rentrez une valeur de résilience supérieure ou égal à 0",
                 "Erreur saisie résilience", 0);
                 return(false);
            } else {
                return(true);
            }
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this, "La valeur de résilience doit être un flottant d'une valeur supérieure ou égale à 0",
                 "Erreur saisie résilience", 0);
                 return(false);
        }
    }
}
