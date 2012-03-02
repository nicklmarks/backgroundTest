import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Hashtable;

public class MySlider extends JPanel
					  implements ActionListener,
								// WindowListener,
								 ChangeListener
{
	static final int FPS_MIN = 0;
	static final int FPS_MAX = 30;
	static final int FPS_INIT = 15;
	int delay;
	Timer timer;
	boolean frozen = false;
	
	
	public  MySlider() 
	{
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		//delay = 1000 / FPS_INIT;
		
		//create the label.
		JLabel speedLabel = new JLabel("Fish Speed", JLabel.CENTER);
		speedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//create the slider.
		JSlider speed = new JSlider(JSlider.HORIZONTAL, FPS_MIN, FPS_MAX, FPS_INIT);
		speed.addChangeListener(this);
		speed.setMajorTickSpacing(10);
		speed.setPaintTicks(true);
		speed.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
		Font font = new Font("Serif", Font.ITALIC, 15);
		speed.setFont(font);
		
		//Create the label table
		Hashtable labelTable = new Hashtable();
		labelTable.put( new Integer(	0		 ), new JLabel( "Stop"	) );
		labelTable.put( new Integer( FPS_MAX / 10), new JLabel( "Slow"	) );
		labelTable.put( new Integer( FPS_MAX / 2 ), new JLabel( "Medium") );
		labelTable.put( new Integer( FPS_MAX	 ), new JLabel( "Fast"	) );
		speed.setLabelTable( labelTable );
		
		speed.setPaintLabels(true);
		
		//Create the FishAnimation on the left side of the screen, should just use the 
		//FishAnimation class and overlay over custion pictures.
		//Create a background color/picture chooser similar to conrads.
		
		//put everything together
		add(speedLabel);
		add(speed);
		//add(animation);
		setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		//set up adjusting the fish
	
	}//Constructor
	
	public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        if (!source.getValueIsAdjusting()) {
            int fps = (int)source.getValue();
            if (fps == 0) {
				if (!frozen) stopAnimation();
            } else {
                delay = 1000 / fps;
                timer.setDelay(delay);
                timer.setInitialDelay(delay * 10);
                if (frozen) startAnimation();
            }
        }
    }//stateChanged()
	
	
    public void startAnimation() {
        //Start (or restart) animating!
        timer.start();
        frozen = false;
    }
	
    public void stopAnimation() {
        //Stop the animating thread.
        timer.stop();
        frozen = true;
    }
	
	//Called when the Timer fires.
    public void actionPerformed(ActionEvent e) {
        //Advance the animation frame.
     /**   if (frameNumber == (NUM_FRAMES - 1)) {
            frameNumber = 0;
        } else {
            frameNumber++;
        }
		
        updatePicture(frameNumber); //display the next picture
		
        if ( frameNumber==(NUM_FRAMES - 1)
			|| frameNumber==(NUM_FRAMES/2 - 1) ) {
            timer.restart();
        } 
	  */
    }
	
	private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("MySlider");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MySlider animator = new MySlider();
		
        //Add content to the window.
        frame.add(animator, BorderLayout.CENTER);
		
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        animator.startAnimation(); 
    }
	
	public static void main(String[] args) {
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        
        
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
	
}//MySlider Class
