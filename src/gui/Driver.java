package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Driver {

	//use to revise existing tabs for personal reference
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Guitar Tab Creator");
		frame.setLayout(new BorderLayout());
		
		frame.setContentPane( new MainPanel());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//frame.setSize(700, 900); //may change later
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	
		
		
		
	}
	
	
			
	
	
}

