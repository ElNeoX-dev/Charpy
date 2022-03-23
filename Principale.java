import java.util.ArrayList;
import java.awt.*;

public class Principale {
    public static void main(String[] args) {
        
        ArrayList<Materiau> maListeMateriau = new ArrayList<Materiau>();

        maListeMateriau.add(new Materiau("Acier S235", 70, new Color(133, 133, 173)));    
        maListeMateriau.add(new Materiau("Acier S335", 60, new Color(54, 53, 53)));
        maListeMateriau.add(new Materiau("Acier S22", 70, new Color(133, 133, 173)));
    }

    // méthode qui crée une éprouvette : 
    public void creationEprouvette (Materiau unMateriau, double section) {
        
    }

    
}
