import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.Timer;

public class Fichiertestpastoucher extends JFrame implements ActionListener {

    
    private Timer chrono;
    public Fichiertestpastoucher() {
        super("Affichage des courbes");
		setSize(1800, 1000);
		setLocation(0, 0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chrono = new Timer(15 ,this);

        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == chrono) {
            
        }
    }


}