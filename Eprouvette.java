import java.awt.Color;
import java.awt.Graphics;

public class Eprouvette {
    // ATTRIBUTS
    Materiau unMateriau;
    double section;

    public Eprouvette() {
        section = 100;
    }

    public Eprouvette (Materiau unMateriau, double uneSection) {
        this.unMateriau=unMateriau;
        section=uneSection;
    }
    
    public String toString(){
		return ("Eprouvette en "+unMateriau.Nom+" de section: "+section+"mm");
	}

    public void dessine(Graphics g) {
        g.setColor(Color.green);
        g.drawRect(600, 500, 50, 50);
    }
}
