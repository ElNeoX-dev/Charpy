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
    Fenetre fen;
    int incrémentationEuler = 0;

    
    public Pendule (int uneMasse, int uneLongueur, double unAngleInitial, double uneVitesseInitiale, double unFrottement, Fenetre fen) {
        this.masse = uneMasse;
        this.longueur = uneLongueur;
        this.longueurReelle = longueur / 100.0;
        theta.add(unAngleInitial);
        omega.add(uneVitesseInitiale);
        this.fen = fen;
        this.frottements = unFrottement;
    }

    public void dessine (Graphics g) {
        g.setColor(Color.blue);
        theta.add(theta.getLast() + 0.015 * omega.getLast());
        omega.add(omega.getLast() + 0.015 * (-longueurReelle*Math.sin(theta.get(theta.size() - 2) / 9.81 + frottements * omega.getLast())));
        centreX = 600;
        centreY = 100;
        finX = (int) (centreX + longueur * Math.sin(theta.getLast()));
        finY = (int) (centreY + longueur * Math.cos(theta.getLast()));
        int r = largeur/2;
        tabX[0] = centreX - longueur * (int)Math.cos(theta.getLast());
        g.setColor(Color.blue);
        g.drawLine(centreX, centreY, finX, finY);
        g.setColor(Color.red);
        g.fillOval(finX - 50, finY - 50, 100, 100);
        //tabX[0] = centreX - r*Math.cos(angle);


        
     }

     public boolean testCollision(Eprouvette e) {
        if(e.estVivant) {
            if(theta.getLast() == 0) {
                if(energieCinetique < e.unMateriau.Resilience) {

                }
                return(true);
            }
        }
        return (false);
     }

     public String toString() {
         return("pendule");
     }
     
}