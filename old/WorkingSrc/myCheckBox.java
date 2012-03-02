//myCheckBox.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class myCheckBox extends JPanel implements ItemListener 
{
    JCheckBox FishButton;
    JCheckBox SpongeBobButton;
    JCheckBox RockFishButton;
    JCheckBox StickFigureButton;
	
    	
    StringBuffer choices;
    JLabel pictureLabel;
	
    public myCheckBox() {
        super(new BorderLayout());
		
        //Create the check boxes.
        FishButton = new JCheckBox("Fish");
        FishButton.setMnemonic(KeyEvent.VK_C);
        FishButton.setSelected(true);
		
        SpongeBobButton = new JCheckBox("SpongeBob");
        SpongeBobButton.setMnemonic(KeyEvent.VK_G);
        SpongeBobButton.setSelected(true);
		
        RockFishButton = new JCheckBox("RockFish");
        RockFishButton.setMnemonic(KeyEvent.VK_H);
        RockFishButton.setSelected(true);
		
        StickFigureButton = new JCheckBox("StickFigure");
        StickFigureButton.setMnemonic(KeyEvent.VK_T);
        StickFigureButton.setSelected(true);
		
        //Register a listener for the check boxes.
        FishButton.addItemListener(this);
        SpongeBobButton.addItemListener(this);
        RockFishButton.addItemListener(this);
        StickFigureButton.addItemListener(this);
		
        //Indicates what's on the geek.
        choices = new StringBuffer("cght");
		
        //Set up the picture label
        pictureLabel = new JLabel();
        pictureLabel.setFont(pictureLabel.getFont().deriveFont(Font.ITALIC));
        updatePicture();
		
        //Put the check boxes in a column in a panel
        JPanel checkPanel = new JPanel(new GridLayout(0, 1));
        checkPanel.add(FishButton);
        checkPanel.add(SpongeBobButton);
        checkPanel.add(RockFishButton);
        checkPanel.add(StickFigureButton);
		
        add(checkPanel, BorderLayout.LINE_START);
        add(pictureLabel, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }
	
    /** Listens to the check boxes. */
    public void itemStateChanged(ItemEvent e) {
        int index = 0;
        char c = '-';
        Object source = e.getItemSelectable();
		
        if (source == FishButton) {
            index = 0;
            c = 'c';
        } else if (source == SpongeBobButton) {
            index = 1;
            c = 'g';
        } else if (source == RockFishButton) {
            index = 2;
            c = 'h';
        } else if (source == StickFigureButton) {
            index = 3;
            c = 't';
        }
		
        //Now that we know which button was pushed, find out
        //whether it was selected or deselected.
        if (e.getStateChange() == ItemEvent.DESELECTED) {
            c = '-';
        }
		
        //Apply the change to the string.
        choices.setCharAt(index, c);
		
        updatePicture();
    }
	
    protected void updatePicture() {
        //Get the icon corresponding to the image.
        ImageIcon icon = createImageIcon(
										 "images/geek/geek-"
										 + choices.toString()
										 + ".gif");
        pictureLabel.setIcon(icon);
        pictureLabel.setToolTipText(choices.toString());
        if (icon == null) {
            pictureLabel.setText("Missing Image");
        } else {
            pictureLabel.setText(null);
        }
    }
	
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = myCheckBox.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
	
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("CheckBoxDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        //Create and set up the content pane.
        JComponent newContentPane = new myCheckBox();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
		
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
	
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
