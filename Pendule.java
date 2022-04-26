import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.*;

public class Pendule {

    double masse;
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
    double energieCinetique;
    Eprouvette ep;
    Fenetre f;
    int EprouDetruite=0; //0=etat initial 1=detruit 2=non detruit

    
    public Pendule (double uneMasse, double uneLongueur, double unAngleInitial, double uneVitesseInitiale, double unFrottement, Eprouvette ep, Fenetre f) {
        this.masse = uneMasse;
        this.longueur = (int)uneLongueur * 100;
        this.longueurReelle = uneLongueur;
        theta.add(unAngleInitial);
        omega.add(uneVitesseInitiale);
        this.ep = ep;
        largeur = longueur / 10;
        this.frottements = unFrottement;
        this.f = f;
    }

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

    public void dessine (Graphics g){
        g.setColor(Color.blue);
        centreX = 600;
        centreY = 100;
        finX = (int) (centreX + longueur * Math.sin(theta.getLast()));
        finY = (int) (centreY + longueur * Math.cos(theta.getLast()));
        int r = largeur / 2;
        tabX[0] = centreX - longueur * (int)Math.cos(theta.getLast());
        theta.add(theta.getLast() + 0.015 * omega.getLast());
        omega.add(omega.getLast() + 0.015 * (-longueurReelle*Math.sin(theta.get(theta.size() - 2) / 9.81 + frottements * omega.getLast())));
        g.setColor(Color.blue);
        g.drawLine(centreX, centreY, finX, finY);
        g.setColor(Color.red);
        g.fillOval(finX - largeur, finY - largeur, 2 * largeur, 2 * largeur);
        //tabX[0] = centreX - r*Math.cos(angle);
        majEnergie();
        testCollision();
        testLimite();
        testFinSimulation();
 
     }

     public void majEnergie() {
         this.energieCinetique = 1.0/2.0 * this.masse * Math.pow(this.longueurReelle * omega.getLast(), 2);
     }

     public void testCollision() {
        if((ep.estVivant && theta.getLast() <= 0)  && (energieCinetique < ep.unMateriau.Resilience*ep.section)) {
            energieCinetique *= 0.2;
            theta.add(0.001);
            omega.add(Math.sqrt(2 * energieCinetique / this.masse) / this.longueurReelle);
            
        } else if(ep.estVivant && (energieCinetique > ep.unMateriau.Resilience*ep.section) && (theta.getLast() <= 0)) {
            energieCinetique-= ep.unMateriau.Resilience*ep.section;
            omega.add(- Math.sqrt(2 * energieCinetique / this.masse) / this.longueurReelle);
            ep.estVivant = false;
            EprouDetruite=1;
        }


     }

     public void testLimite() {
         if(Math.abs(theta.getLast()) > 3.12) {
            f.limiteAtteinte();
         }
     }

     public void testFinSimulation() {
         if(Math.abs(theta.getLast()) < 0.005 && Math.abs(omega.getLast()) < 0.005 
         && f.lancement.getBackground() == Color.green) {
             f.ecritureResultat();
         }
     }

     public String toString() {
         return("pendule");
     }
     
}
