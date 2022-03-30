import java.awt.Color;
import java.awt.Graphics;

public class Eprouvette {
    // ATTRIBUTS
    Materiau unMateriau;
    double section;
    boolean estVivant;
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
        g.fillRect(530, 75 + hauteur, 20, 50);
    }
}
