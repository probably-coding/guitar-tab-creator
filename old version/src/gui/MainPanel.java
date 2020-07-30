package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class MainPanel extends JPanel{

	private String songTitle = "";
	
	
	public MainPanel() {
		
		setLayout(new BorderLayout());
		
		
//WELCOME PAGE		
		
		newWelcomePanel();
		
//MAIN PAGE
		
		newTopPanel();
		newCenterPanel();
		newBottomPanel();
		newChordRefPanel();
		
//BUTTON ACTION LISTENERS	
		
//button takes user from welcome page to main page 
		createTab.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				removeAll();
				revalidate();
				repaint();
						

				
				add(topPanel, BorderLayout.NORTH);
				//add(centerPanel, BorderLayout.CENTER);
				add(bottomPanel, BorderLayout.SOUTH);
				add(pane, BorderLayout.CENTER);
				
			}
			
		});
		
		
//button brings up a reference sheet to all chords
		chordReference.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				removeAll();
				revalidate();
				repaint();
				
				add(chordRefPanel);
				
			}
			
		});
		

//button adds a blank line to the tab
		addLine.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				//keep track of linePanel objects
				LinePanel l = new LinePanel();
				centerPanel.add(l);
				
				//add(centerPanel, BorderLayout.CENTER);
				add(pane, BorderLayout.CENTER);
				revalidate();
				repaint();
			}
			
		});
		
		
		
		
		
//button saves the users work into a file 
		finished.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				songTitle = String.valueOf(
						JOptionPane.showInputDialog("Enter song (and artist) name:",
							"Cold by Rich Brian"));
				
				
				removeAll();
				revalidate();
				repaint();
				
				//add(new FinalPanel());
				
				
				//figure out how to let user save work
				
			}
			
		});
		
		
//button takes the user from the chord reference page back to the main page 
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				removeAll();
				revalidate();
				repaint();
				
				add(topPanel, BorderLayout.NORTH);
				//add(centerPanel, BorderLayout.CENTER);
				add(bottomPanel, BorderLayout.SOUTH);
				add(pane, BorderLayout.CENTER);
				
				
				
			}
			
		});
		
		
	}
	
	
//PANEL CONSTRUCTION METHODS
	
//setting up WELCOME panel
	private JPanel welcomePanel = new JPanel(new BorderLayout());
	private JLabel welcome = new JLabel();
	private JLabel welcomeLabel = new JLabel();
	private Font titleFont = new Font("Arial", Font.BOLD, 30); //maybe change later
	private JButton createTab = new JButton("Create a Tab");

	public void newWelcomePanel() {
		
		welcome.setText("Welcome to Guitar Tab Creator!");
		welcome.setBackground(Color.white);
		welcome.setOpaque(true);
		welcome.setHorizontalAlignment(JLabel.CENTER);
		welcome.setFont(titleFont);
		//Border border = BorderFactory.createLineBorder(Color.BLACK);
	    //welcome.setBorder(border);
		welcomePanel.add(welcome, BorderLayout.NORTH);

		ImageIcon welcomeImageIcon = new ImageIcon("images/guitarsketch.jpg");
		Image welcomeImage = welcomeImageIcon.getImage();
		Image resizedWelcomeImage = welcomeImage.getScaledInstance(500, 695, Image.SCALE_DEFAULT);
		ImageIcon welcomeIcon = new ImageIcon(resizedWelcomeImage);
		welcomeLabel = new JLabel(welcomeIcon);
		welcomeLabel.setBackground(Color.white);
		welcomeLabel.setOpaque(true);

		welcomePanel.add(welcomeLabel, BorderLayout.CENTER);

		welcomePanel.add(createTab, BorderLayout.SOUTH);

		add(welcomePanel, BorderLayout.CENTER);

	}
	
//setting up TOP panel
	private JPanel topPanel = new JPanel(new BorderLayout());
	JLabel title = new JLabel();
	JLabel titleLabel = new JLabel();
	
	public void newTopPanel() {
		
		ImageIcon titleImageIcon = new ImageIcon("images/guitarsketch.jpg");
		Image titleImage = titleImageIcon.getImage();
		Image resizedTitleImage = titleImage.getScaledInstance(100, 125, Image.SCALE_DEFAULT);
		ImageIcon titleIcon = new ImageIcon(resizedTitleImage);
		titleLabel = new JLabel(titleIcon);
		
		title.setText("Guitar Tab Creator");
		title.setFont(titleFont);
		title.setBackground(Color.white);
		title.setOpaque(true);
		topPanel.add(titleLabel, BorderLayout.WEST);
		topPanel.add(title, BorderLayout.CENTER);
	}

//setting up CENTER panel	
	private JPanel centerPanel = new JPanel();
	private JScrollPane pane = new JScrollPane(centerPanel, 
			ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	
	public void newCenterPanel() {
		
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		centerPanel.add(new LinePanel());
		
	}

//setting up BOTTOM panel	
	private JPanel bottomPanel = new JPanel(new BorderLayout());
	private JButton chordReference = new JButton("Chords Reference");
	private JButton addLine = new JButton("Add Line");
	private JButton finished = new JButton("Finished");
	
	public void newBottomPanel() {
		
		bottomPanel.setBackground(Color.white);
		bottomPanel.add(chordReference, BorderLayout.WEST);
		bottomPanel.add(addLine, BorderLayout.CENTER);
		bottomPanel.add(finished, BorderLayout.EAST);
	}

//setting up CHORD REFERENCE panel	
	private JPanel chordRefPanel = new JPanel(new BorderLayout());
	JLabel titleCR = new JLabel();
	private JLabel titleLabelCR = new JLabel();

	private JPanel chordsPanel = new JPanel();
	private JPanel backPanel = new JPanel();
	private JButton back = new JButton("Back");
	private JLabel chordChart;
	
	public void newChordRefPanel() {
		
		chordsPanel.setLayout(new BorderLayout());
		chordsPanel.setBackground(Color.white);
		
		ImageIcon titleImageIcon = new ImageIcon("images/guitarsketch.jpg");
		Image titleImage = titleImageIcon.getImage();
		Image resizedTitleImage = titleImage.getScaledInstance(100, 125, Image.SCALE_DEFAULT);
		ImageIcon titleIcon = new ImageIcon(resizedTitleImage);
		titleLabelCR = new JLabel(titleIcon);
		
		titleCR.setText("Chords Reference");
		titleCR.setFont(titleFont);
		titleCR.setBackground(Color.white);
		titleCR.setOpaque(true);
		
		chordsPanel.add(titleLabelCR, BorderLayout.WEST);
		chordsPanel.add(titleCR, BorderLayout.CENTER);

		
		

		// add chord names and images to chordsPanel here
		
		ImageIcon chordsImageIcon = new ImageIcon("images/chords.jpg");
		Image chordsImage = chordsImageIcon.getImage();
		Image resizedChordsImage = chordsImage.getScaledInstance(450, 600, Image.SCALE_DEFAULT);
		ImageIcon chordsIcon = new ImageIcon(resizedChordsImage);
		
		chordChart = new JLabel(chordsIcon);
		
		chordsPanel.add(chordChart, BorderLayout.SOUTH);
		
		chordRefPanel.add(chordsPanel, BorderLayout.CENTER);
		
		backPanel.setBackground(Color.white);
		backPanel.add(back);
		chordRefPanel.add(backPanel, BorderLayout.SOUTH);

	}


	

	public ImageIcon convertImage(ImageIcon i) {
		
		Image image = i.getImage();
		Image resized = image.getScaledInstance(100, 125, Image.SCALE_DEFAULT);
		ImageIcon output = new ImageIcon(resized);

		return output;
	}
	
	
	
	
	
	
}
