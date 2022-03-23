import java.awt.Color;
import java.awt.Graphics;

public class Pendule {

    int masse;
    int longueur;
    int largeur = 50;
    int angle;
    int vitesse;
    int [] tabX = new int [8];
    int [] tabY = new int [8];
    int centreX;
    int centreY;

    
    public Pendule (double uneMasse, double uneLongueur, double unAngleInitial, double uneVitesseInitiale) {
        this.masse=uneMasse;
        this.longueur=uneLongueur;
        this.angle=unAngleInitial;
        this.vitesse=uneVitesseInitiale;
    }

    public void dessine (Graphics g) {
        g.setColor(Color.blue);
        centreX = 750;
        centreY = 100;
        int r = largeur/2;
        tabX[0] = centreX - r*Math.cos(angle);

        
     }
}