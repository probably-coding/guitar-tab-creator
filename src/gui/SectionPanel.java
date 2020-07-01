package gui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SectionPanel extends JPanel{

	JPanel topPanel;
	JPanel centerPanel;
	JPanel bottomPanel;
	JLabel title;
	JButton addLine;	
	JButton deleteSection;
	int lineCount;
	
	
	public SectionPanel(String s) {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		title = new JLabel(s);
		addLine = new JButton("Add Line");
		deleteSection = new JButton("Delete Section");
		
		lineCount = 0;
		
		
	}
}
