import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

//implements GUI
public class GUI {
	//initialize variables
    private JFrame frame;
	
	private JLabel label1;
	//private JLabel label2;
	
	private JSlider slider1;
	private JPanel slider2;
	private JPanel checkbox;

	private picturePanel panel;
	private JPanel panel2;
	//these locations will probably be part of another class, just place holder for piece starting locations
    private int x = 850;
    private int y = 850;
	private int x2 = 850;
    private int y2 = 850;

    public static void main (String[] args){	
	GUI gui = new GUI();
	gui.setup();
    }
    
    public void setup() {
	//sets up the GUI
	
		frame = new JFrame(); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		panel = new picturePanel();
		panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
	
		label1 = new JLabel("Number of Fish");
		slider1 = new JSlider(JSlider.HORIZONTAL, 0, 30, 15);
		//slider1.addChangeListener(this);
		
		//Turn on labels at major tick marks.
		slider1.setMajorTickSpacing(10);
		slider1.setMinorTickSpacing(1);
		slider1.setPaintTicks(true);
		slider1.setPaintLabels(true);
		
	//	label2 = new JLabel("Fish Speed");
		slider2 = new MySlider();
		checkbox = new myCheckBox();
	
		panel2.add(label1);
		panel2.add(slider1);
		//panel2.add(label2);
		panel2.add(slider2);
		panel2.add(checkbox);
	
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.getContentPane().add(BorderLayout.EAST, panel2);
	//	frame.getContentPane().add(BorderLayout.NORTH, header);
		frame.setSize(1200,960);
		frame.setVisible(true);
    }

	class picturePanel extends JPanel {
		//inner class
		//adds the graphics on panel. this method is called when the PANEL is initiated. and when frame.repaint() is called
		public void paintComponent(Graphics g) {
			Image image = new ImageIcon("ocean-fish-01.jpg").getImage();
			g.drawImage(image,0,0,this);
/*		g.setColor(Color.blue);
		g.fillOval(x,y,20,20);
		g.setColor(Color.green);
		g.fillOval(x2+20,y2+20,20,20);
 */
		}
	}
}