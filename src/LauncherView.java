import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class LauncherView extends JFrame{
	ImageIcon bgImg;
	
	JLabel background;
	JLabel lblTitle;
	JButton btnPlay;
	JButton btnInst;
	
	public LauncherView() {
		super("Animal Chess");
		
		initMenu();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(420, 290);
		setResizable(false);
		setLayout(null);
		setVisible(true);
	}
	
	public void initMenu() {
		lblTitle = new JLabel("ANIMAL CHESS", JLabel.CENTER);
		lblTitle.setFont(new Font("Helvetica", Font.BOLD, 40));
		lblTitle.setBounds(-45, 35, 500, 40);
		lblTitle.setForeground(new Color(0, 100, 0));
		
		btnPlay = new JButton("PLAY");
		btnPlay.setForeground(Color.WHITE);
		btnPlay.setFont(new Font("Helvetica", Font.BOLD, 10));
		btnPlay.setBounds(100, 100, 200, 40);
		btnPlay.setFocusable(false);
		btnPlay.setBackground(new Color(85,107,47));
		
		
		btnInst = new JButton("INSTRUCTIONS");
		btnInst.setForeground(Color.WHITE);
		btnInst.setFont(new Font("Helvetica", Font.BOLD, 10));
		btnInst.setBounds(100, 160, 200, 40);
		btnInst.setFocusable(false);
		btnInst.setBackground(new Color(85,107,47));
		
		bgImg = new ImageIcon("images/BG.jpg");
		
		background = new JLabel("", bgImg, JLabel.CENTER);
		background.setBounds(0, 0, 450, 300);
		
		background.add(lblTitle);
		background.add(btnPlay);
		background.add(btnInst);
		
		add(background);
	}
	
	public void setListener(ActionListener listener) {
		btnPlay.addActionListener(listener);
		btnInst.addActionListener(listener);
	}
	
}
