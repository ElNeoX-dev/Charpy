public class Eprouvette {
    // ATTRIBUTS
    Materiau unMateriau;
    double Section;

    public Eprouvette (Materiau unMateriau, double uneSection) {
        this.unMateriau=unMateriau;
        Section=uneSection;
    }
    
    public String toString(){
		return ("Eprouvette en "+unMateriau.Nom+" de section: "+Section+"mm");
	}
}
