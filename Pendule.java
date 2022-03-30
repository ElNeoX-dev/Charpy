import java.awt.Color;
import java.awt.Graphics;

public class Pendule {

    int masse;
    int longueur = 500;
    int largeur = 50;
    double angle;
    int vitesse;
    int [] tabX = new int [8];
    int [] tabY = new int [8];
    int centreX;
    int centreY;
    int finX;
    int finY;
    double energieInitiale;

    
    public Pendule (int uneMasse, int uneLongueur, double unAngleInitial, int uneVitesseInitiale) {
        this.masse=uneMasse;
        this.longueur=uneLongueur;
        this.angle=unAngleInitial;
        this.vitesse=uneVitesseInitiale;
        this.energieInitiale = 1/2*masse*Math.pow(2,uneVitesseInitiale)+masse*9.81*(longueur*Math.cos(unAngleInitial));
    }

    public void dessine (Graphics g) {
        g.setColor(Color.blue);
        centreX = 500;
        centreY = 100;
        finX = (int) (centreX + longueur * Math.sin(angle));
        finY = (int) (centreY + longueur * Math.cos(angle));
        int r = largeur/2;
        tabX[0] = centreX - longueur * (int)Math.cos(angle);
        g.setColor(Color.blue);
        g.drawLine(centreX, centreY, finX, finY);
        g.setColor(Color.red);
        g.fillOval(finX - 50, finY - 50, 100, 100);
        //tabX[0] = centreX - r*Math.cos(angle);

        
     }

     public void getVitesse () {
        double energieCinetique = energieInitiale-(9.81*masse*longueur*Math.cos(angle));
        double vitesseAngulaire = Math.sqrt(2*energieCinetique/masse)/longueur;
     }

     public String toString() {
         return(longueur + " " + angle);
     }
     
}