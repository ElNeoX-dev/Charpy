/**
 * Classe permettant l'affichage de la simulation
 * @author WARIN, CAMPRUBI, BRUSQUE, CHAMPOUILLON
 */ 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.lang.Integer;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class Fenetre extends JFrame implements ActionListener {

    // Attributs

    // Conteneurs
    public JPanel monConteneur1;
    public Dessin monConteneur2;
    public JPanel monConteneurMain;

    // Zone de textes
    public JTextArea TxtaffichageResultat;
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

    // Pendule et Eprouvette
    private Pendule p;
    private Eprouvette ep;

    // Boutons
    public JButton majPendule;
    public JButton lancement;
    public JButton creationMat;

    // Slider
    public JSlider CoefFrottements;
    public JComboBox<String> choixMat;

    // Chrono et temps
    private Timer chrono;
    public double tempsMs = 0;
    
    // Messages initiaux d'affichage
    public String MessageInitial="Bienvenue sur le simulateur de Mouton de \n" + "Charpy\n" + "\n"+"Pour commencer :\n"
    + "-Chosissez vos valeurs\n" + "-Appuyez sur le bouton Reset\n" + "-Appuyez sur le bouton Lancer";
    public String resumeSimulation;

    // Base de donnée des matériaux
    public ArrayList<Materiau> maListeMateriau;
    String[] listeMat;


    /**
     * Le constructeur de la fenêtre d'affichage de la simulation
     */
    public Fenetre() {

        // Paramètres de la fenêtre
        super("Affichage des courbes");
        setLocation(0, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Initialisation de la base de donnée des matériauxs
        maListeMateriau = new ArrayList<Materiau>();
        initListeMateriau();
        choixMat = new JComboBox<String>(listeMat);
        choixMat.setBounds(160, 640, 120, 50);
        choixMat.addActionListener(this);
  
        // Initialisation quelques variables
        this.ep = new Eprouvette(maListeMateriau.get(0), 100, 500);
        this.p = new Pendule(1.0, 5, 0, 0, 0, ep);
        chrono = new Timer(1, this);

        // Initialisation des conteneurs

        // Conteneur de saisie des données
        monConteneur1 = new JPanel();
        monConteneur1.setLayout(null);
        monConteneur1.setBounds(0, 0, 300, 1000);
        monConteneur1.setBackground(Color.lightGray);

        // Conteneur d'affichage de la simulation
        monConteneur2 = new Dessin(p, ep);
        monConteneur2.setLayout(null);
        monConteneur2.setBounds(300, 0, 1500, 1000);// JPanel esapce dessin = new Dessin (pendule,eprouvette)
        monConteneur2.setBackground(Color.white);

        monConteneurMain = new JPanel();
        monConteneurMain.setLayout(null);

        monConteneurMain.add(monConteneur1);
        monConteneurMain.add(monConteneur2);
        this.add(monConteneurMain);


        // Initialisation des boutons

        // Bouton de lancement de la simulation 
        lancement = new JButton("Lancer");
        lancement.setBounds(20, 180, 120, 40);
        lancement.setBackground(Color.red);
        lancement.addActionListener(this);
        monConteneur1.add(lancement);

        // Bouton de mise à jour du pendule
        majPendule = new JButton("Reset");
        majPendule.setBounds(150, 180, 120, 40);
        majPendule.setBackground(Color.red);
        majPendule.addActionListener(this);
        monConteneur1.add(majPendule);

        // Bouton de création d'un matériau
        creationMat = new JButton("Créer un materiau");
        creationMat.setBounds(75, 720, 150, 40);
        creationMat.addActionListener(this);
        monConteneur1.add(creationMat);

        // Initialisation des zones de textes et des étiquettes

        // Zone d'affichage des résultats
        affichageResultat = new JLabel();
        affichageResultat.setText("Affichage résultat");
        affichageResultat.setBounds(80, 5, 260, 30);
        monConteneur1.add(affichageResultat);

        TxtaffichageResultat = new JTextArea(MessageInitial); // affichage résultat
        TxtaffichageResultat.setBounds(20, 40, 260, 120);
        TxtaffichageResultat.setBackground(Color.white);
        monConteneur1.add(TxtaffichageResultat);

        // Zone de saisie de la taille de la tige
        tailleTige = new JLabel();
        tailleTige.setText("Taille tige (m)");
        tailleTige.setBounds(160, 480, 120, 30);
        monConteneur1.add(tailleTige);

        TxtTailleTige = new JTextField(5); // taille tige
        TxtTailleTige.setBounds(160, 520, 120, 60);
        TxtTailleTige.setBackground(Color.white);
        monConteneur1.add(TxtTailleTige);

        // Zone de saisie de l'angle initial du pendule
        angleInitial = new JLabel();
        angleInitial.setText("Angle initial en °");
        angleInitial.setBounds(20, 360, 120, 30);
        monConteneur1.add(angleInitial);

        TxtAngleInitial = new JTextField(0); // hauteur départ
        TxtAngleInitial.setBounds(20, 400, 120, 60);
        TxtAngleInitial.setBackground(Color.white);
        monConteneur1.add(TxtAngleInitial);

        // Zone de saisie de la masse du pendule
        masseMarteau = new JLabel();
        masseMarteau.setText("masse marteau (kg)");
        masseMarteau.setBounds(160, 360, 120, 30);
        monConteneur1.add(masseMarteau);

        TxtMasseMarteau = new JTextField(1); // masse marteau
        TxtMasseMarteau.setBounds(160, 400, 120, 60);
        TxtMasseMarteau.setBackground(Color.white);
        monConteneur1.add(TxtMasseMarteau);

        // Zone de saisie de la masse initial du pendule
        vitesseInitiale = new JLabel();
        vitesseInitiale.setText("Vitesse initiale (m/s)");
        vitesseInitiale.setBounds(20, 480, 120, 30);
        monConteneur1.add(vitesseInitiale);

        TxtVinit = new JTextField(0); // Vinit
        TxtVinit.setBounds(20, 520, 120, 60);
        TxtVinit.setBackground(Color.white);
        monConteneur1.add(TxtVinit);

        // Zone de saisie de l'épaisseur de l'éprouvette
        epaisseurEprouvette = new JLabel();
        epaisseurEprouvette.setText("Epaisseur éprouvette (cm)");
        epaisseurEprouvette.setBounds(20, 600, 150, 30);
        monConteneur1.add(epaisseurEprouvette);

        TxtEpaisseurEprouvette = new JTextField(0); // épaisseur éprouvette
        TxtEpaisseurEprouvette.setBounds(20, 640, 120, 60);
        TxtEpaisseurEprouvette.setBackground(Color.white);
        monConteneur1.add(TxtEpaisseurEprouvette);

        // Texte du Slider de frottement
        coeffFrottements = new JLabel();
        coeffFrottements.setText("Coeff frottements");
        coeffFrottements.setBounds(90, 240, 120, 30);
        monConteneur1.add(coeffFrottements);

        // Initialisation du slider pour le coeff de frottements
        CoefFrottements = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        CoefFrottements.setBounds(20, 280, 260, 60);
        monConteneur1.add(CoefFrottements);
        CoefFrottements.setMajorTickSpacing(10);
        CoefFrottements.setMinorTickSpacing(0);
        CoefFrottements.setPaintTicks(true);
        CoefFrottements.setPaintLabels(true);

        monConteneur1.add(choixMat);

        // Affichage de la fenêtre
        setVisible(true);
    }


    /**
     * Permet d'activer ou de désactiver le chrono
     * @param un booleen
     */  
    public void setChrono(boolean etat) {

        if(etat == false) {

            chrono.stop();

        } else {

            chrono.start();

        }

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == chrono && lancement.getBackground() == Color.green) { // La couleur verte signifie que la simulation est lancée

            if(p.testCollision()) {

                if(ep.estVivant) {

                    TxtaffichageResultat.setText("l'éprouvette n'a pas été détruite");

                } else {

                    TxtaffichageResultat.setText("l'éprouvette a été détruite");

                }

            }
            
            if(p.testLimite()) {

                majPendule.doClick(); // Simule un appui sur le bouton Reset
                resumeSimulation += "!!! Les limites de la simulation ont été atteintes !!! \n Cela peut être du à une vitesse initiale trop grande. \n";
                JOptionPane.showMessageDialog(this,"Limite de simulation atteinte", "Erreur simulation !", 0);

            }
            
            if(p.testFinSimulation() && lancement.getBackground() == Color.green) {

                ecritureResultat();

            }

            repaint(); // Mets à jour le dessin

        }


        if (e.getSource() == lancement) { // Maj de la couleur du bouton et du chrono

            if (lancement.getBackground() == Color.red) {

                lancement.setBackground(Color.green);
                chrono.start();
                lancement.setText("Pause");
                
            } else {

                lancement.setBackground(Color.red);
                chrono.stop();
                lancement.setText("Lancer");

            }

        }


        if (e.getSource() == majPendule) {
            
            majPendule.setBackground(Color.green);
            majPendule.setText("Mettre à jour");
            double frottements = CoefFrottements.getValue() / 1000.0; // Récupération de la valeur du Slider
            chrono.stop();
            if(verifValeur()) {

                this.ep = new Eprouvette(maListeMateriau.get(choixMat.getSelectedIndex()), Double.parseDouble(TxtEpaisseurEprouvette.getText()),
                Double.parseDouble(TxtTailleTige.getText())*100); // Création de la nouvelle éprouvette
                    
                // Maj du nouveau pendule
                p.resetPendule(Double.parseDouble(TxtMasseMarteau.getText()), Double.parseDouble(TxtTailleTige.getText()),
                (Math.PI/180.0) * Double.parseDouble(TxtAngleInitial.getText()), -1 * Double.parseDouble(TxtVinit.getText()), frottements, ep);
   
                monConteneur2.maj(p, ep);
                lancement.setBackground(Color.red);
                repaint();

                // Préparation de l'entête d'affichage du compté-rendu de la simulation
                TxtaffichageResultat.setText(MessageInitial);
                resumeSimulation ="*** Compte-rendu de la simulation *** \n" +
                "Conditions initiales de la simulation : \n" +
                "Angle initial = " +  TxtAngleInitial.getText() + "degre\n" +
                "Vitesse initial = " + TxtVinit.getText() + " m/s\n" +
                "Taille tige = " + TxtTailleTige.getText() + " m\n" +
                "Masse marteau = " + TxtMasseMarteau.getText() + " kg\n" +
                "Coefficient de frottements = " + frottements + "\n" +
                "Section Eprouvette = " + TxtEpaisseurEprouvette.getText() + " cm*cm \n" + 
                "Materiau eprouvette : " + maListeMateriau.get(choixMat.getSelectedIndex()).Nom
                + " de resilience : " + maListeMateriau.get(choixMat.getSelectedIndex()).Resilience + " J/cm*cm \n";
            
            }

        }

        // Ouverture de la fenêtre de création d'un matériau
        if(e.getSource() == creationMat) {

            FenetreCreationMat fcreation = new FenetreCreationMat(maListeMateriau, choixMat);

        }

    }


    /**
     * Ecrit les résultats de la simulation dans un fichier texte dans le dossier output
     */  
    public void ecritureResultat() {

        // Initialisation du nom du fichier
        SimpleDateFormat formatDatePourNomFichier = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String datePourNomFichier = formatDatePourNomFichier.format(new Date());
        String nomFichier = "resultat_" + datePourNomFichier + ".csv";

        // L'association try/catch permet en cas d'erreur d'afficher un message universel qui sera inscrit dans le catch
        // Il est obligatoire ici pour que le writer s'initialise
        try { 

            // Création du writer
            BufferedWriter writer = new BufferedWriter(new FileWriter("./output/" + nomFichier, false));

            // On écrit le résumé de la simulation
            writer.append(resumeSimulation);
            if(ep.estVivant) {

                writer.append("L'eprouvette n'a pas ete detruite ! \n");

            } else {

                writer.append("L'eprouvette a ete detruite ! \n");

            }

            // Cette partie de permet d'écrire l'historique des données de l'angle et de la vitesse angulaire
            // Les données pourront ainsi être traité dans Excel
            writer.append("temps (ms);angleRad;vitesseAngulaire \n");

            // Permet d'optimiser l'acquisition des données pour l'écriture
            Double[] thetaFinal = new Double[p.theta.size()];
            Double[] omegaFinal = new Double[p.omega.size()];

            int j = 0;
            for(Double t : p.theta) {
                thetaFinal[j] = t;
                j++;
            }

            j = 0;
            for(Double o : p.omega) {
                omegaFinal[j] = o;
                j++;
            }

            for (int i = 0; i < thetaFinal.length; i++) {

                writer.append(i * 15 + ";" + thetaFinal[i] + ";" + omegaFinal[i] + "\n");

            }

            writer.close(); // Permet de fermer le writer

        // Le catch va 'attraper' les erreurs et afficher un message unique
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this, "Le dossier output est introuvable", "Erreur écriture des résultats", 0);

        }



        // Message de confirmation que la simulation s'est bien passé
        JOptionPane.showMessageDialog(this,"Simulation terminée ! \n Résultats disponibles dans le dossier output."
        , "Simulation réussie !", 1);

        majPendule.doClick(); // Simule un appui sur le bouton Reset
    }


    /**
     * Permet de vérifier si les valeurs saisies respectent le cahier des charges ou possède le bon type
     * @return un boolean qui confirme si les valeurs sont correctes ou non
     */  
    public boolean verifValeur(){
        
        // Permet de détecter si les données saisies possède le bon type ou non
        try {

            if(Integer.parseInt(TxtTailleTige.getText()) > 6) {

                JOptionPane.showMessageDialog(this,"Merci de ne pas dépasser 6 m de longueur de tige afin de ne pas sortir de la taille de la fenêtre"
                , "Erreur saisie données", 0);
                return(false);
        
            } else if(Double.parseDouble(TxtAngleInitial.getText()) > 175) {

                JOptionPane.showMessageDialog(this,"Merci de choisir un angle inférieur ou égal à 175° afin de ne pas sortir des limites de la simulation"
                , "Erreur saisie données", 0);
                return(false);

            } else if (Double.parseDouble(TxtAngleInitial.getText()) <= 5){

                JOptionPane.showMessageDialog(this,"Merci de choisir un angle supérieur à 5° afin de pouvoir lancer la simulation"
                , "Erreur saisie données", 0);
                return(false);
        
            } else if(Double.parseDouble(TxtEpaisseurEprouvette.getText()) < 0) {

                JOptionPane.showMessageDialog(this,"Merci de choisir une épaisseur supérieure ou égale à 0"
                , "Erreur saisie données", 0);
                return(false);

            } else {

                Double.parseDouble(TxtVinit.getText());  // Permet de vérifier que la vitesse est un double, sinon envoyé dans le catch
                return(true);

            }

        // Si le code entre dans cette méthode, c'est qu'une des données ne possède pas le bon type
        } catch(Exception ex) {

            JOptionPane.showMessageDialog(this, "Valeurs saisies incorrectes\r Verifiez que les types des données sont corrects !", "Erreur saisie", 0);
            return(false);

        }
    }


    /**
     * Permet d'initialiser la liste des matériaux à partir du fichier BDMat.txt
     */  
    public void initListeMateriau() {

        // Obligatoire pour le BufferedReader
        try {
            
            // Permet de lire le fichier texte
            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("BDMat.txt")));
  
            // Ici on va lire ligne par ligne le fichier texte en séparant les données grâce aux virgules
            String ligne;
            final String SEPARATEUR = ",";

            while((ligne = input.readLine()) != null) {

                String attributs[] = ligne.split(SEPARATEUR);
                double res = Double.parseDouble(attributs[1]);
                Color c = new Color(Integer.parseInt(attributs[2]), Integer.parseInt(attributs[3])
                , Integer.parseInt(attributs[4]), Integer.parseInt(attributs[5]));
                maListeMateriau.add(new Materiau(attributs[0], res, c));

            }
                // Liste d'affichage pour la JComboBox
                listeMat = new String[maListeMateriau.size()];
                for (int i = 0; i < listeMat.length; i++) {

                    listeMat[i] = maListeMateriau.get(i).Nom;

                }

            input.close(); // Fermeture de la lecture

        } catch(Exception e) { // Si erreur dans le fichier BDMat.txt

            JOptionPane.showMessageDialog(this, "Une erreur est présente dans le fichier BDMat.txt\n Veuillez vérifier les données."
            , "Erreur fichier", 0);
            this.dispose(); // Fermeture de la fenêtre

        }
    }
}


