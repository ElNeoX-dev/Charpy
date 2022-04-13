import java.util.ArrayList;
import java.awt.*;

public class BaseDonneeMateriaux{

public ArrayList<Materiau> maListeMateriau;

	public BaseDonneeMateriaux(){
		
		maListeMateriau = new ArrayList<Materiau>();
        maListeMateriau.add(new Materiau("Acier S235", 70, new Color(133, 133, 173)));
        maListeMateriau.add(new Materiau("Acier S335", 60, new Color(54, 53, 53)));
        maListeMateriau.add(new Materiau("Acier S22", 70, new Color(133, 133, 173)));
        maListeMateriau.add(new Materiau("Acier F65-R850", 60, new Color(133, 133, 173)));
        maListeMateriau.add(new Materiau("Acier F65-Rv550", 50, new Color(133, 133, 173)));
        maListeMateriau.add(new Materiau("Acier F65-Rv200", 30, new Color(133, 133, 173)));
        maListeMateriau.add(new Materiau("Acier Inox X5CrNi18-10", 120, new Color(224, 224, 224)));
        maListeMateriau.add(new Materiau("Polyamide 11", 40, new Color(96, 96, 96)));
        maListeMateriau.add(new Materiau("Nylon 6-6", 200, new Color(96, 96, 96)));
        maListeMateriau.add(new Materiau("PVC", 320, new Color(96, 96, 96)));
        maListeMateriau.add(new Materiau("Polycarboante", 200, new Color(224, 224, 224)));
        maListeMateriau.add(new Materiau("PTFE", 160, new Color(220, 220, 220)));
        maListeMateriau.add(new Materiau("Bois de châtaignier", 6, new Color(102, 56, 0)));
        maListeMateriau.add(new Materiau("Bois de chêne", 7.5, new Color(102, 56, 0)));
        maListeMateriau.add(new Materiau("Noyer", 9.5, new Color(102, 56, 0)));
        maListeMateriau.add(new Materiau("bois de Hêtre", 12, new Color(102, 56, 0)));
        maListeMateriau.add(new Materiau("Epicéa", 5, new Color(102, 56, 0)));


	}
}
	
