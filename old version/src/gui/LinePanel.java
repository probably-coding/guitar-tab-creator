package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class LinePanel extends JPanel {

	String lyric = "";

	protected static int count;
	private int number;

	public LinePanel() {

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		newChordPanel();
		newLyricsPanel();
		newSpacePanel();



//BUTTON ACTION LISTENERS
		
//deletes selected line panel
		deleteLine.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}

		});

//clears selected line panel 
		clearLine.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				removeAll();
				revalidate();
				repaint();

				newChordPanel();
				newLyricsPanel();
				newSpacePanel();

			}

		});

		count++;
		
	}

//PANEL CONSTRUCTION METHODS
	
//setting up chords panel		
	private JPanel chordsPanel;

	public void newChordPanel() {

	
		chordsPanel = new JPanel(new GridLayout(1, 20));
		chordsPanel.setBackground(Color.white);
		// adding chord buttons
		for (int i = 0; i < 20; i++) {
			chordsPanel.add(new ChordButton());
		}

		add(chordsPanel);

	}
	
	
//setting up lyrics panel
	private JPanel lyricsPanel;
	private JLabel lyricLine;
	private final int hGap = 5;
	private final int vGap = 15;
	
	
	public void newLyricsPanel() {

		lyricsPanel = new JPanel(new BorderLayout());
		lyricsPanel.setBackground(Color.white);
		lyricLine = new JLabel("Click to add lyrics");
		lyricLine.setBackground(Color.white);
		lyricLine.setOpaque(true);
		lyricLine.setHorizontalAlignment(JLabel.LEFT);
		lyricLine.setVerticalAlignment(JLabel.TOP);
		lyricsPanel.add(lyricLine, BorderLayout.CENTER);
		lyricsPanel.setBorder(BorderFactory.createEmptyBorder(0, vGap, 0, 0));

		add(lyricsPanel);

		//JLabel mouse listener 

		lyricLine.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				lyric = String.valueOf(JOptionPane.showInputDialog("Enter lyric line:",
						"saw a car crash, it remind me of our first date"));
				lyricLine.setText(lyric);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {

				// lyricLine.setText(lyric);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}

//setting up space panel
	private JPanel spacePanel;
	private JButton clearLine;
	static JButton deleteLine;
	
	public void newSpacePanel() {

		spacePanel = new JPanel();
		spacePanel.setBackground(Color.white);
		clearLine = new JButton("Clear line");
		deleteLine = new JButton("Delete line");

		spacePanel.add(clearLine);
		spacePanel.add(deleteLine);

		add(spacePanel);

	}

	public int getCount() {
		return count;
	}

	public String getLyric() {
		return lyric;
	}

}
