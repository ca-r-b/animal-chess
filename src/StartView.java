import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class StartView extends JFrame {
	
	private ShuffleButton[] btnShuffled;
	private JLabel lblStatus;
	
	private JButton btnRed;
	private JButton btnBlue;
	
	public StartView() {
		super("Animal Chess");
		setLayout(new BorderLayout());
		
		initShuffle();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(800, 500);
		setVisible(true);
	}
	
	public void initShuffle() {
		// NORTH PANEL
		JPanel northPanel = new JPanel();
		
		northPanel.setLayout(new FlowLayout());
		
		lblStatus = new JLabel("(PLAYER 1) SELECT AMONG THE RANDOMIZED PIECES!", JLabel.CENTER);
		lblStatus.setFont(new Font("Calibri", Font.BOLD, 15));
		
		northPanel.add(lblStatus);
		
		add(northPanel, BorderLayout.NORTH);
		
		// CENTER PANEL
		JPanel centerPanel = new JPanel();
		
		centerPanel.setLayout(new FlowLayout());
		
		btnShuffled = new ShuffleButton[8];
		
		for (int i = 0; i < btnShuffled.length; i++) {
			btnShuffled[i] = new ShuffleButton(i);
			
			btnShuffled[i].setText("Random Piece No. " + (i+1));
			btnShuffled[i].setPreferredSize(new Dimension(170, 170));
			btnShuffled[i].setBackground(Color.WHITE);
			btnShuffled[i].setFocusable(false);
			
			centerPanel.add(btnShuffled[i]);
		}
		
		add(centerPanel, BorderLayout.CENTER);
		
		// SOUTH PANEL
		JPanel southPanel = new JPanel();
		
		southPanel.setLayout(new FlowLayout());
		
		btnRed = new JButton("TEAM RED");
		btnBlue = new JButton("TEAM BLUE");
		
		btnRed.setPreferredSize(new Dimension(120, 50));
		btnBlue.setPreferredSize(new Dimension(120, 50));
		
		btnRed.setFocusable(false);
		btnBlue.setFocusable(false);
		
		btnRed.setEnabled(false);
		btnBlue.setEnabled(false);
		
		btnRed.setBackground(Color.WHITE);
		btnBlue.setBackground(Color.WHITE);
		
		southPanel.add(btnRed);
		southPanel.add(btnBlue);
		
		add(southPanel, BorderLayout.SOUTH);
	}
	
	public void showChosenAnimal(String p) {
		for(int i = 0; i < btnShuffled.length; i++) {
			if((!btnShuffled[i].isEnabled()) && btnShuffled[i].getIcon() == null) {
				ImageIcon img = new ImageIcon("images/" + p + ".png");
				btnShuffled[i].setText("");
				btnShuffled[i].setIcon(img);
				break;
			}
		}
	}
	
	public void setLblStatus(String t) {
		lblStatus.setText(t);
	}
	
	public void setAllShuffleEnabled(boolean t) {
		for (int i = 0; i < btnShuffled.length; i++) {
			btnShuffled[i].setEnabled(t);
		}
	}
	
	public void setShuffleEnabled(int i, boolean t) {
		btnShuffled[i].setEnabled(t);
	}
	
	public void setBtnEnabled(boolean t) {
		btnRed.setEnabled(t);
		btnBlue.setEnabled(t);
	}
	
	public void setActionListener(ActionListener listener) {
		btnRed.addActionListener(listener);
		btnBlue.addActionListener(listener);
	}
	
	public void setMouseListener(MouseListener listener) {
		for (int i = 0; i < btnShuffled.length; i++) {
			btnShuffled[i].addMouseListener(listener);
		}
	}
}
