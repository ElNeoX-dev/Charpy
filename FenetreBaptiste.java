import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class FenetreBaptiste extends JFrame implements ActionListener {
   
    private Timer monTimer;

    public FenetreBaptiste () {
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        monTimer = new Timer (100,this);
        monTimer.start();
    }

    public void ActionPerformed(ActionEvent e){

    }
}
