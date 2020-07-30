package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class ChordButton extends JButton{
	
	private String chord = "";
	
	

	public ChordButton() {
		
		setPreferredSize(new Dimension(24, 24));
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String[] choices = { "", "A", "A7", "Am", "Am7", "Amaj7",
						 "B♭", "B7", "Bm",
						 "C", "C7", "Cmaj7", 
						 "D", "D7", "Dm", "Dm7", "Dmaj7",
						 "E", "E7", "Em", "Em7",
						 "F", "Fmaj7", "G", "G7",};
			    chord = (String) JOptionPane.showInputDialog(null, "Use the"
			    		+ " dropdown menu below to choose a chord:",
			        "Choose a Chord", JOptionPane.QUESTION_MESSAGE, null, 
			        choices, // Array of choices
			        choices[1]); // Initial choice
				
			    setText(chord);
				
			}
			
		});
		
		
	}
	
	
	public String getChord() {
		return chord;
	}
	
	
}
