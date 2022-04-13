import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// To play sound using Clip, the process need to be alive.
// Hence, we use a Swing application.

public class Sons extends JFrame {
	Clip Ambiance;
	public Sons(){
		this.setTitle("Son");
		this.setSize(300, 200);
		this.setVisible(false);
	}


	public void musiques(String t) {
		try {
			// Open an audio input stream.
			URL url = this.getClass().getClassLoader().getResource(t);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			// Get a sound clip resource.
			Clip clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
   	
   
    public void sonChute() {
		musiques("Heal.wav");
    }
    

   public void sonAmbiance(){
      try{
      URL url = this.getClass().getClassLoader().getResource("Battle.wav");
         AudioInputStream ais = AudioSystem.getAudioInputStream(url);
         final Clip clip = AudioSystem.getClip();
         this.Ambiance=clip;
         clip.open( ais );
         Runnable r = new Runnable(){
            public void run() {
               JFrame frame = new JFrame("Gestion de la musique");
               frame.setDefaultCloseOperation(2);
               final JToggleButton startStop = new JToggleButton("Stop");
               startStop.addActionListener( new ActionListener() {
                  public void actionPerformed(ActionEvent ae) {
                     if (startStop.isSelected()) {
                        clip.stop();
                        startStop.setText("Start");
                     } else {
                        clip.loop(-1);
                        clip.start();
                        startStop.setText("Stop");
                        }
                    }
                } );
               clip.loop(-1);
               frame.add(startStop, BorderLayout.NORTH);
               frame.setSize(310, 80);
               frame.setAlwaysOnTop(true);
               frame.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
    }
}
