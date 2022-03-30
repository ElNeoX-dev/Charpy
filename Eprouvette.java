import java.awt.Color;
import java.awt.Graphics;

public class Eprouvette {
    // ATTRIBUTS
    Materiau unMateriau;
    double section;
    boolean estVivant;
    int hauteur = 500;

    public Eprouvette() {
        section = 100;
    }

    public Eprouvette (Materiau unMateriau, double uneSection) {
        this.unMateriau=unMateriau;
        section=uneSection;
        estVivant = true;
    }
    
    public String toString(){
		return ("Eprouvette en "+unMateriau.Nom+" de section: "+section+"mm");
	}

    public void dessine(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(530, 75 + hauteur, 20, 50);
    }
}
