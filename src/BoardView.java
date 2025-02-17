import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class BoardView extends JFrame{
	
	private TileButton[][] btnTiles;
	
	private JLabel lblPlayerStatus;
	
	public BoardView() {
		super("Animal Chess");
		
		btnTiles = new TileButton[7][9];
		
		setLayout(new BorderLayout(7,9));
		
		initBoard();
		
		//setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(1000, 650);
		setVisible(true);
	}
	
	
	public void initBoard() {
		JPanel centerPanel = new JPanel();
		
		centerPanel.setLayout(new GridLayout(7, 9));
		
		btnTiles = new TileButton[7][9];
		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 9; j++) {
				btnTiles[i][j] = new TileButton(i, j);
			}
		}
		
		// Set Dens
		btnTiles[3][0] = new TileButton(3, 0, "images/Red Den.png");
		btnTiles[3][8] = new TileButton(3, 8, "images/Blue Den.png");

		// Set Traps
		btnTiles[2][0] = new TileButton(2, 0, "images/Red Trap.png");
		btnTiles[3][1] = new TileButton(3, 1, "images/Red Trap.png");
		btnTiles[4][0] = new TileButton(4, 0, "images/Red Trap.png");

		btnTiles[2][8] = new TileButton(2, 8, "images/Blue Trap.png");
		btnTiles[3][7] = new TileButton(3, 7, "images/Blue Trap.png");
		btnTiles[4][8] = new TileButton(4, 8, "images/Blue Trap.png");

		// Set Rivers
		btnTiles[1][3] = new TileButton(1, 3, "images/River.png");
		btnTiles[1][4] = new TileButton(1, 4, "images/River.png");
		btnTiles[1][5] = new TileButton(1, 5, "images/River.png");

		btnTiles[2][3] = new TileButton(2, 3, "images/River.png");
		btnTiles[2][4] = new TileButton(2, 4, "images/River.png");
		btnTiles[2][5] = new TileButton(2, 5, "images/River.png");

		btnTiles[4][3] = new TileButton(4, 3, "images/River.png");
		btnTiles[4][4] = new TileButton(4, 4, "images/River.png");
		btnTiles[4][5] = new TileButton(4, 5, "images/River.png");

		btnTiles[5][3] = new TileButton(5, 3, "images/River.png");
		btnTiles[5][4] = new TileButton(5, 4, "images/River.png");
		btnTiles[5][5] = new TileButton(5, 5, "images/River.png");

		// Set Red Animal Pieces
		btnTiles[6][2] = new TileButton(6, 2, "images/Red Mouse.png");
		btnTiles[1][1] = new TileButton(1, 1, "images/Red Cat.png");
		btnTiles[2][2] = new TileButton(2, 2, "images/Red Wolf.png");
		btnTiles[5][1] = new TileButton(5, 1, "images/Red Dog.png");
		btnTiles[4][2] = new TileButton(4, 2, "images/Red Leopard.png");
		btnTiles[0][0] = new TileButton(0, 0, "images/Red Tiger.png");
		btnTiles[6][0] = new TileButton(6, 0, "images/Red Lion.png");
		btnTiles[0][2] = new TileButton(0, 2, "images/Red Elephant.png");

		// Set Blue Animal Pieces
		btnTiles[0][6] = new TileButton(0, 6, "images/Blue Mouse.png");
		btnTiles[5][7] = new TileButton(5, 7, "images/Blue Cat.png");
		btnTiles[4][6] = new TileButton(4, 6, "images/Blue Wolf.png");
		btnTiles[1][7] = new TileButton(1, 7, "images/Blue Dog.png");
		btnTiles[2][6] = new TileButton(2, 6, "images/Blue Leopard.png");
		btnTiles[6][8] = new TileButton(6, 8, "images/Blue Tiger.png");
		btnTiles[0][8] = new TileButton(0, 8, "images/Blue Lion.png");
		btnTiles[6][6] = new TileButton(6, 6, "images/Blue Elephant.png");

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 9; j++) {
				btnTiles[i][j].setFocusable(false);
				centerPanel.add(btnTiles[i][j]);
			}
		}
		
		add(centerPanel, BorderLayout.CENTER);
		
		lblPlayerStatus = new JLabel("IT'S YOUR TURN: PLAYER 1!", JLabel.CENTER);
		lblPlayerStatus.setFont(new Font("Calibri", Font.BOLD, 15));
		
		add(lblPlayerStatus, BorderLayout.NORTH);
	}
	
	public void setStatus(boolean t) {
		if(t) {
			lblPlayerStatus.setText("IT'S YOUR TURN: PLAYER 1!");
		}else {
			lblPlayerStatus.setText("IT'S YOUR TURN: PLAYER 2!");
		}
	}
	
	public void setMouseListener(MouseListener listener) {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 9; j++) {
				btnTiles[i][j].addMouseListener(listener);
			}
		}
	}
	
	public void setTileEnabled(boolean b, int y, int x) {
		btnTiles[y][x].setEnabled(b);
	}
	
	public void refreshRiver() {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 9; j++) {
				if((i == 1 || i == 2 || i == 4 || i == 5) && (j == 3 || j == 4 || j == 5)) {
					if(btnTiles[i][j].getBtnIcon() == null) {
						ImageIcon temp = new ImageIcon("images/River.png");
						btnTiles[i][j].setBtnIcon(temp);
						btnTiles[i][j].setFileLoc("images/River.png");
					}
				}
			}
		}	
	}
	
	public void refreshTrap() {
		ImageIcon temp1 = new ImageIcon("images/Red Trap.png");
		ImageIcon temp2 = new ImageIcon("images/Blue Trap.png");
		
		if(btnTiles[2][0].getBtnIcon() == null) {
			btnTiles[2][0].setBtnIcon(temp1);
			btnTiles[2][0].setFileLoc("images/Red Trap.png");
		}
			
		if(btnTiles[3][1].getBtnIcon() == null) {
			btnTiles[3][1].setBtnIcon(temp1);
			btnTiles[3][1].setFileLoc("images/Red Trap.png");
		}
		
		if(btnTiles[4][0].getBtnIcon() == null) {
			btnTiles[4][0].setBtnIcon(temp1);
			btnTiles[4][0].setFileLoc("images/Red Trap.png");
		}
		
		if(btnTiles[2][8].getBtnIcon() == null) {
			btnTiles[2][8].setBtnIcon(temp2);
			btnTiles[2][8].setFileLoc("images/Blue Trap.png");
		}
		
		if(btnTiles[3][7].getBtnIcon() == null) {
			btnTiles[3][7].setBtnIcon(temp2);
			btnTiles[3][7].setFileLoc("images/Blue Trap.png");
		}
		
		if(btnTiles[4][8].getBtnIcon() == null) {
			btnTiles[4][8].setBtnIcon(temp2);
			btnTiles[4][8].setFileLoc("images/Blue Trap.png");
		}
	}
	
	public void updateBoard(int curY, int curX, int newY, int newX) {
		
		btnTiles[newY][newX].setBtnIcon(btnTiles[curY][curX].getBtnIcon()); // Store 2nd img to 1st img
		btnTiles[newY][newX].setFileLoc(btnTiles[curY][curX].getFileLoc());
		this.setEnabled(true);

		btnTiles[curY][curX].setBtnIcon(null); // Store 1st img to 2nd img
		btnTiles[curY][curX].setFileLoc(null);
		btnTiles[curY][curX].refresh();
		btnTiles[curY][curX].setEnabled(true);
		
		btnTiles[newY][newX].refresh();
		btnTiles[curY][curX].refresh();
		
		refreshRiver();
		refreshTrap();
	}
}
