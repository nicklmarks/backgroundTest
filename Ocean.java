import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Ocean extends JFrame{
	DrawingPanel oceanPanel = new DrawingPanel();
	int maxX = 250;
	int maxY = 250;
	int maxWidth = 100;
//	BufferedImage myPicture = new BufferedImage();
	//BufferedImage myPicture = ImageIO.read(new File (Users/NickMarks/Documents/School/Computer_Science/cs56/backgroundTest/ocean-turtle.jpg));

	public Ocean() {
		getContentPane().add(oceanPanel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(maxX,maxY);
		setVisible(true);
	}
	
	class DrawingPanel extends JPanel{
		public void paintComponent(Graphics g){
			Graphics2D g2 = (Graphics2D) g;
			BufferedImage myPicture = new BufferedImage(maxX,maxY, 0);
			try {
				myPicture = ImageIO.read(new File("path-to-file"));
			}
			catch(Exception ex) { System.out.println(ex); }
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			this.add(picLabel);
		}
	}//ends DrawingPanel

	public static void main(String[] args){
		new Ocean();
	}
}

//from internet, how to get picture to show up on screen.
	//BufferedImage myPicture = ImageIO.read(new File("path-to-file"));
	//JLabel picLabel = new JLabel(new ImageIcon( myPicture ));
	//add( picLabel );
