import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.awt.*;
import java.io.*;
import java.lang.Integer;

public class BaseDonneeMateriaux{

public ArrayList<Materiau> maListeMateriau;

	public BaseDonneeMateriaux(Fenetre f){
		
		maListeMateriau = new ArrayList<Materiau>();
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("BDMat.txt")));

            String ligne;
            final String SEPARATEUR = ",";
            while((ligne = input.readLine()) != null) {

                String attributs[] = ligne.split(SEPARATEUR);
                double res = Double.parseDouble(attributs[1]);
                Color c = new Color(Integer.parseInt(attributs[2]), Integer.parseInt(attributs[3]), Integer.parseInt(attributs[4]));

                maListeMateriau.add(new Materiau(attributs[0], res, c));
            }

        } catch(Exception e) {
            JOptionPane.showMessageDialog(f, "Une erreur est présente dans le fichier BDMat.txt\n Veuillez vérifier les données."
            , "Erreur fichier", 0);
        }
	}
}
	
