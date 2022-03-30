import java.awt.Color;
import java.awt.Graphics;
import java.util.function.UnaryOperator;

public class Pendule {

    int masse;
    int longueur = 500;
    double longueurReelle;
    int largeur = 50;
    double angle;
    double angleInitial;
    int vitesse;
    int [] tabX = new int [8];
    int [] tabY = new int [8];
    int centreX;
    int centreY;
    int finX;
    int finY;
    double energieInitiale;
    double vitesseAngulaire;
    double energieCinetique;
    double omega;

    
    public Pendule (int uneMasse, int uneLongueur, double unAngleInitial, int uneVitesseInitiale) {
        this.masse = uneMasse;
        this.longueur = uneLongueur;
        this.longueurReelle = longueur / 100.0;
        this.angle = unAngleInitial;
        this.vitesse = uneVitesseInitiale;
        this.angleInitial = unAngleInitial;
        this.energieInitiale = 1.0 /2.0 * masse * Math.pow(2,uneVitesseInitiale)+masse*9.81*(longueur*Math.cos(unAngleInitial));
        this.energieCinetique = 1.0 / 2.0 * masse * Math.pow(2,uneVitesseInitiale);
    }

    public void dessine (Graphics g) {
        g.setColor(Color.blue);
        centreX = 600;
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

     public void majVitesse () {
        //energieCinetique = energieInitiale-(9.81*masse*longueur*Math.cos(angle));
        //vitesseAngulaire = Math.sqrt(2*energieCinetique/masse)/longueur;
        omega = 1/ (Math.sqrt(longueurReelle / 9.81) * (1 + Math.pow(angleInitial, 2) / 16));
         }

     public boolean testCollision(Eprouvette e) {
        return(true);
     }

     public void majPos(double temps) {
        this.majVitesse();
        angle = angleInitial * Math.exp(-0.1* omega * temps) * Math.cos(Math.sqrt(1-0.01) * omega * temps);
     }

     public String toString() {
         return("pendule");
     }
     
}