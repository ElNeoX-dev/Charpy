/**
 * Classe permettant l'affichage de la simulation
 * @author WARIN, CAMPRUBI, BRUSQUE, CHAMPOUILLON
 */ 

import java.awt.Color;
import java.awt.Graphics;


public class Eprouvette {

    // ATTRIBUTS
    Materiau unMateriau;
    double section;
    boolean estVivant=true;
    int hauteur; // hauteur d'affichage
    Color couleur = Color.green;

    
    /**
     * Constructeur de la classe éprouvette
     * @param Materiau un materiau, double une section d'éprouvett, double une hauteur
     */  
    public Eprouvette (Materiau unMateriau, double uneSection, double hauteur) {

        this.unMateriau = unMateriau;
        section = uneSection;
        estVivant = true;
        this.hauteur = (int)hauteur;
        couleur = unMateriau.Couleur;

    }


    /**
     * Méthode permettant de déssiner l'éprouvette
     * @param Graphics une zone de dessin
     */  
    public void dessine(Graphics g) {

		g.setColor(couleur);
		if(estVivant==true) {	

			g.fillRect(580 - hauteur / 10, 75 + hauteur, 20, 50);

		} else {

            // Affichage de l'éprouvette cassée
			g.fillRect(480, 760, 8, 10);
			g.fillRect(490, 765, 5, 15);
			g.fillRect(499, 763, 6, 7);
			g.fillRect(520, 760, 10, 10);
			g.fillRect(545, 763, 20, 7);
			g.fillRect(572, 761, 14, 9);

		}
    }
}
