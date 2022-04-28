/**
 * Classe permettant l'affichage de la simulation
 * @author WARIN, CAMPRUBI, BRUSQUE, CHAMPOUILLON
 */ 

import java.awt.event.*;  
import java.awt.*;  
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class FenetreCreationMat extends JFrame implements ActionListener {
    
    // Atributs

    // Conteneurs
    public JPanel conteneurMain;
    public JPanel conteneurCouleur;

    // Boutons
    public JButton boutonCreation;
    public JButton boutonChoixCouleur;
    
    // Zone de texte
    public JLabel nom;
    public JLabel resilience;
    public JTextField txtNom;
    public JTextField txtRes;

    // Autres
    JComboBox<String> comboBox;
    ArrayList<Materiau> maListeMateriau;
    Color couleur;

    
    /**
     * Constructeur de la classe affichant la fenetre de création d'un matériau
     * @param la fenetre d'affichage principale
     */  
    public FenetreCreationMat(ArrayList<Materiau> maListeMateriau, JComboBox<String> comboBox) {

        // Paramètre de la fenêtre
        super("Création Matériau");
        setSize(330, 320);
        setLocation(500, 200);

        this.maListeMateriau = maListeMateriau;
        this.comboBox = comboBox;

        // Initialisation des conteneurs

        // Conteneur principal
        conteneurMain = new JPanel();
        conteneurMain.setLayout(null);
        conteneurMain.setBackground(Color.lightGray);

        // Conteneur affichant la couleur choisie
        conteneurCouleur = new JPanel();
        conteneurCouleur.setLayout(null);
        conteneurCouleur.setBackground(Color.blue);
        conteneurCouleur.setBounds(230, 150, 40, 40);
        conteneurMain.add(conteneurCouleur);

        // Initialisation des boutons

        // Bouton ouvrant le JChooseColor
        boutonChoixCouleur = new JButton("Choisir une couleur");
        boutonChoixCouleur.setBounds(5, 150, 150, 40);
        boutonChoixCouleur.addActionListener(this);
        conteneurMain.add(boutonChoixCouleur);

        // Bouton de création du matériau
        boutonCreation = new JButton("Créer !");
        boutonCreation.setBounds(90, 220, 120, 40);
        boutonCreation.addActionListener(this);
        conteneurMain.add(boutonCreation);

        // Initialisation des zones de textes

        // Zone de saisie du nom
        nom = new JLabel("Nom : ");
        nom.setBounds(5, 10, 120, 30);
        conteneurMain.add(nom);

        txtNom = new JTextField();
        txtNom.setBounds(5, 50, 150, 60);
        conteneurMain.add(txtNom);

        // Zone de saisie de la résilience
        resilience = new JLabel("Résilience : ");
        resilience.setBounds(160, 10, 150, 30);
        conteneurMain.add(resilience);

        txtRes = new JTextField();
        txtRes.setBounds(160, 50, 150, 60);
        conteneurMain.add(txtRes);

        this.add(conteneurMain);

        // Affichage de la fenêtre
        setVisible(true);

    }


    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == boutonChoixCouleur) {

            // Ouverture du JColorChooser permettant de choisir une couleur
            couleur = JColorChooser.showDialog(this, "Choisissez une couleur", Color.blue);
            conteneurCouleur.setBackground(couleur);

        } else {

            creationMat();

        }

    }


    /**
     * Méthode permettant de créer un matériau dans le fichier BDMat.txt
     */  
    public void creationMat() {

        try {

            // La valeur true signifie que le fichier existe déjà
            BufferedWriter writer = new BufferedWriter(new FileWriter("BDMat.txt", true));
            if(verifValeur()) {

                // Ecriture des valeurs dans le fichier texte
                writer.write("\r" + txtNom.getText() + "," + txtRes.getText() + "," + couleur.getRed() 
                + "," + couleur.getGreen() + "," + couleur.getBlue() + "," + couleur.getAlpha());
                maListeMateriau.add(new Materiau(txtNom.getText(), Double.parseDouble(txtRes.getText()), couleur));
                comboBox.addItem(txtNom.getText());
                JOptionPane.showMessageDialog(this, "Le matériau a bien été créé \n un redémarrage peut être nécéssaire", "Opération réussie !", 2);
                this.dispose(); // Fermeture de la fenêtre

            }

            writer.close(); // Fin de l'écriture
            
        } catch (Exception ex) { // Obligatoire pour le BufferedWriter

            JOptionPane.showMessageDialog(this, "Erreur dans l'écriture du fichier BDMat.txt",
            "Erreur écriture fichier", 0);

        }

    }


    /**
     * Méthode permettant de vérifier que les valeurs saisies sont correctes
     * @return Si les valeurs sont correctes ou non
     */  
    public boolean verifValeur() {

        try {

            if(Double.parseDouble(txtRes.getText()) < 0) {

                JOptionPane.showMessageDialog(this, "Veuillez rentrez une valeur de résilience supérieure ou égal à 0",
                 "Erreur saisie résilience", 0);
                 return(false);

            } else {

                return(true);

            }
        } catch(Exception ex) { // Si la valeur saisie n'est pas un double

            JOptionPane.showMessageDialog(this, "La valeur de résilience doit être un flottant d'une valeur supérieure ou égale à 0",
                 "Erreur saisie résilience", 0);
                 return(false);

        }

    }

}
