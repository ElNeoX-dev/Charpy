import java.awt.Color;
import java.awt.Graphics;

public class Eprouvette {
    // ATTRIBUTS
    Materiau unMateriau;
    double section;
    boolean estVivant=true;
    int hauteur;
    Color couleur = Color.green;

    public Eprouvette() {
        section = 100;
        hauteur = 500;
    }

    public Eprouvette (Materiau unMateriau, double uneSection, int hauteur) {
        this.unMateriau=unMateriau;
        section=uneSection;
        estVivant = true;
        this.hauteur = hauteur;
        couleur = unMateriau.Couleur;
    }
    
    public String toString(){
		return ("Eprouvette en "+unMateriau.Nom+" de section: "+section+"mm");
	}

    public void dessine(Graphics g) {
		g.setColor(couleur);
		if(estVivant==true){	
			g.fillRect(530, 75 + hauteur, 20, 50);
		}else{
			g.fillRect(480, 890, 8, 10);
			g.fillRect(490, 885, 5, 15);
			g.fillRect(499, 893, 6, 7);
			g.fillRect(520, 890, 10, 10);
			g.fillRect(545, 893, 20, 7);
			g.fillRect(572, 891, 14, 9);
		}
    }
}
