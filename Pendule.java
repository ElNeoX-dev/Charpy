import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

public class Pendule {

    int masse;
    int longueur = 500;
    double longueurReelle;
    int largeur = 50;
    double frottements = 0.01;
    LinkedList<Double> theta = new LinkedList<Double>();
    LinkedList<Double> omega = new LinkedList<Double>();
    int [] tabX = new int [8];
    int [] tabY = new int [8];
    int centreX;
    int centreY;
    int finX;
    int finY;
    double energieInitiale;
    double energieCinetique;
    Eprouvette ep;
    int incrémentationEuler = 0;

    
    public Pendule (int uneMasse, int uneLongueur, double unAngleInitial, double uneVitesseInitiale, double unFrottement, Eprouvette ep) {
        this.masse = uneMasse;
        this.longueur = uneLongueur;
        this.longueurReelle = longueur / 100.0;
        theta.add(unAngleInitial);
        omega.add(uneVitesseInitiale);
        this.ep = ep;
        this.frottements = unFrottement;
    }

    public void dessine (Graphics g) {
        g.setColor(Color.blue);
        centreX = 600;
        centreY = 100;
        finX = (int) (centreX + longueur * Math.sin(theta.getLast()));
        finY = (int) (centreY + longueur * Math.cos(theta.getLast()));
        int r = largeur/2;
        tabX[0] = centreX - longueur * (int)Math.cos(theta.getLast());
        theta.add(theta.getLast() + 0.015 * omega.getLast());
        omega.add(omega.getLast() + 0.015 * (-longueurReelle*Math.sin(theta.get(theta.size() - 2) / 9.81 + frottements * omega.getLast())));
        g.setColor(Color.blue);
        g.drawLine(centreX, centreY, finX, finY);
        g.setColor(Color.red);
        g.fillOval(finX - 50, finY - 50, 100, 100);
        //tabX[0] = centreX - r*Math.cos(angle);
        testCollision();
 
     }

     public void majEnergie() {
         this.energieCinetique = 1.0/2.0 * this.masse * Math.pow(this.longueurReelle * omega.getLast(), 2);
     }

     public void testCollision() {
        if(ep.estVivant && theta.getLast() < 0.01 && theta.getLast() > - 0.01 && energieCinetique < ep.unMateriau.Resilience) {
            theta.clear();
            omega.clear();
            energieCinetique -= ep.unMateriau.Resilience;
            theta.add(0.0);
            omega.add(Math.sqrt(2 * energieCinetique / this.masse) / this.longueurReelle);
            
        }


     }

     public String toString() {
         return("pendule");
     }
     
}