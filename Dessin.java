import javax.swing.*;
import java.awt.*;

public class Dessin extends JPanel {
    Pendule pendule;
    Eprouvette eprou;
    public Dessin(Pendule pend, Eprouvette epr) {
        pendule = pend;
        eprou = epr;
        this.setLayout(null);
        this.setBackground(Color.black);
        this.setBounds(300, 0, 1500, 1000);
    }

    public void paintComponent(Graphics g) {
        pendule.dessine(g);
        eprou.dessine(g);
 
        //g.fillRect(750, 750, 50, 100);
    }

    public void maj(Pendule p, Eprouvette e) {
        
    }
}
