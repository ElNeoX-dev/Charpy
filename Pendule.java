/**
 * Classe définissant le type Pendule
 * @author WARIN, CAMPRUBI, BRUSQUE, CHAMPOUILLON
 */ 


import java.awt.Color;
import java.awt.Graphics;
import java.util.*;


public class Pendule {

    // Attributs
    double masse;
    int longueur = 500; // Longueur affichage
    double longueurReelle; // 100 pixels = 1 mètre
    int largeur = 50;
    double frottements = 0.01;

    LinkedList<Double> theta = new LinkedList<Double>();
    LinkedList<Double> omega = new LinkedList<Double>();

    //Point de début et de fin de la tige
    int centreX;
    int centreY;
    int finX;
    int finY;

    double energieCinetique;
    Eprouvette ep;


    /**
     * Constructeur de la classe Pendule
     * @param les paramètre du pendules
     */  
    public Pendule (double uneMasse, double uneLongueur, double unAngleInitial, double uneVitesseInitiale, double unFrottement, Eprouvette ep) {

        this.masse = uneMasse;
        this.longueur = (int)uneLongueur * 100;
        this.longueurReelle = uneLongueur;
        theta.add(unAngleInitial);
        omega.add(uneVitesseInitiale);
        this.ep = ep;
        largeur = longueur / 10;
        this.frottements = unFrottement;

    }


    /**
     * Méthode permettant de mettre à jour les paramètre du pendule
     * @param les nouveaux paramètre du pendule
     */  
    public void resetPendule(double uneMasse, int uneLongueur, double unAngleInitial, double uneVitesseInitiale, double unFrottement, Eprouvette ep) {

        theta.clear();
        omega.clear();
        this.masse = uneMasse;
        this.longueur = uneLongueur * 100;
        this.longueurReelle = longueur / 100.0;
        largeur = longueur / 10;
        theta.add(unAngleInitial);
        omega.add(uneVitesseInitiale);
        this.ep = ep;
        this.frottements = unFrottement;

    }


    /**
     * Méthode permettant de dessiner le pendule
     * @param un grahique
     */  
    public void dessine (Graphics g){

        g.setColor(Color.blue);
        centreX = 600;
        centreY = 100;
        finX = (int) (centreX + longueur * Math.sin(theta.getLast()));
        finY = (int) (centreY + longueur * Math.cos(theta.getLast()));

        // Résolution d'équation différentielle avec ici la méthode Euler explicite
        theta.add(theta.getLast() + 0.015 * omega.getLast());
        omega.add(omega.getLast() + 0.015 * (-longueurReelle*Math.sin(theta.get(theta.size() - 2) / 9.81 + frottements * omega.getLast())));

        g.setColor(Color.blue);
        g.drawLine(centreX, centreY, finX, finY);
        g.setColor(Color.red);
        g.fillOval(finX - largeur, finY - largeur, 2 * largeur, 2 * largeur);

        majEnergie();
     }


    /**
     * Méthode permettant de mettre à àjour l'énergie cinétique du pendule
     */  
     public void majEnergie() {

        this.energieCinetique = 1.0/2.0 * this.masse * Math.pow(this.longueurReelle * omega.getLast(), 2);

     }


    /**
     * Méthode permettant de déterminer s'il y a collision avec l'éprouvette
     * @return S'il y a un contact
     */  
    public boolean testCollision() {

        if((ep.estVivant && theta.getLast() <= 0)  && (energieCinetique < ep.unMateriau.Resilience*ep.section)) {

            energieCinetique *= 0.2;
            theta.add(0.001);
            omega.add(Math.sqrt(2 * energieCinetique / this.masse) / this.longueurReelle);
            return(true);
            
        } else if(ep.estVivant && (energieCinetique > ep.unMateriau.Resilience*ep.section) && (theta.getLast() <= 0)) {

            energieCinetique-= ep.unMateriau.Resilience*ep.section;
            omega.add(- Math.sqrt(2 * energieCinetique / this.masse) / this.longueurReelle);
            ep.estVivant = false;
            return(true);

        } else {

            return(false);

        }

     }


    /**
     * Méthode déterminant si le pendule dépasse les limites de la simulation
     * @return Si la limite de simulation a été atteinte
     */  
    public boolean testLimite() {

        return(Math.abs(theta.getLast()) > 3.12);

    }


    /**
     * Méthode permettant de déterminer si le pendule est immobile
     * @return Si la simulation est terminée
     */  
    public boolean testFinSimulation() {

        return(Math.abs(theta.getLast()) < 0.005 && Math.abs(omega.getLast()) < 0.005); 
        
    }
     
}
