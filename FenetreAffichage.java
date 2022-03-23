import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.Timer;

public class FenetreAffichage extends JFrame implements ActionListener {

    
    private Timer chrono;
    public FenetreAffichage() {
        super("Affichage des courbes");
		setSize(1800, 1000);
		setLocation(0, 0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chrono = new Timer(15 ,this);

        
        setVisible(true);
    }
}