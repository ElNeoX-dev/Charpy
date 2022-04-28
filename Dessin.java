/**
 * Classe permettant l'affichage de la simulation
 * @author WARIN, CAMPRUBI, BRUSQUE, CHAMPOUILLON
 */ 

import javax.swing.*;
import java.awt.*;


public class Dessin extends JPanel {

    // Attributs
    Pendule pendule;
    Eprouvette eprou;


    /**
     * Constructeur de la zone de dessin
     * @param Un pendule et une eprouvette
     */  
    public Dessin(Pendule pend, Eprouvette epr) {

        pendule = pend;
        eprou = epr;
        this.setLayout(null);
        this.setBackground(Color.black);
        this.setBounds(300, 0, 1500, 1000);

    }
 
    public void paintComponent(Graphics g) {

        pendule.dessine(g);
        eprou.dessine(g);

    }

    /**
     * Méthode méttant à jour l'épourvette et le pendule à déssiner
     * @param Le pendule et l'éprouvette
     */  
    public void maj(Pendule p, Eprouvette e) {

        this.pendule = p;
        this.eprou = e;

    }
}
