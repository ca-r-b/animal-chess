import java.awt.event.*;

import javax.swing.JOptionPane;

public class BoardController implements MouseListener{
	
	TileButton chosenTile = null; // First Piece clicked by Player
	
	private BoardView bv;
	private Board b;
	private Player[] p;
	
	public BoardController(BoardView bv, Board b, Player[] p) {
		this.bv = bv;
		this.b = b;
		this.p = p;
		
		if(p[0].getIsTurn()) {
			bv.setStatus(true);
		}else {
			bv.setStatus(false);
		}
		
		bv.setMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		TileButton theTile = (TileButton) e.getComponent(); // Get component (together with its properties)
			
		if(p[0].getIsTurn()) { // Know the player's turn
			if(chosenTile == null) { // If player has not selected a piece yet
				chosenTile = theTile;
				if(p[0].selectPiece(b, theTile.getYP(), theTile.getXP())) { // Check if valid tile
					bv.setTileEnabled(false, chosenTile.getYP(), chosenTile.getXP()); // Update board and show selected piece
				}else {
					chosenTile = null; // Set to null if invalid piece
				}
			}else { // If player has selected a piece, have him select a destination tile
				if(p[0].movePiece(b, chosenTile.getYP(), chosenTile.getXP(), theTile.getYP(), theTile.getXP())) {
					bv.updateBoard(chosenTile.getYP(), chosenTile.getXP(), theTile.getYP(), theTile.getXP());
					chosenTile = null;
					p[1].setIsTurn(true);
					p[0].setIsTurn(false);
					bv.setStatus(false);
				}else {
					bv.setTileEnabled(true, chosenTile.getYP(), chosenTile.getXP());
					chosenTile = null;
				}
			}
		}
		
		if(p[1].getIsTurn()) {
			if(chosenTile == null) {
				chosenTile = theTile;
				if(p[1].selectPiece(b, theTile.getYP(), theTile.getXP())) {
					bv.setTileEnabled(false, chosenTile.getYP(), chosenTile.getXP());
				}else {
					chosenTile = null;
				}
			}else {
				if(p[1].movePiece(b, chosenTile.getYP(), chosenTile.getXP(), theTile.getYP(), theTile.getXP())) {
					bv.updateBoard(chosenTile.getYP(), chosenTile.getXP(), theTile.getYP(), theTile.getXP());
					chosenTile = null;
					p[0].setIsTurn(true);
					p[1].setIsTurn(false);
					bv.setStatus(true);
				}else {
					bv.setTileEnabled(true, chosenTile.getYP(), chosenTile.getXP());
					chosenTile = null;
				}
			}
		}
		
		if(b.checkBlueDen() || b.checkBluePieces()) {
			// RED wins
			JOptionPane.showMessageDialog(null, "WE HAVE A WINNER! TEAM RED WINS!", "Animal Chess", JOptionPane.PLAIN_MESSAGE);
		}else if(b.checkRedDen() || b.checkRedPieces()) {
			// BLUE wins
			JOptionPane.showMessageDialog(null, "WE HAVE A WINNER! TEAM BLUE WINS!", "Animal Chess", JOptionPane.PLAIN_MESSAGE);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {	
	}

	@Override
	public void mouseReleased(MouseEvent e) {		
	}

	@Override
	public void mouseEntered(MouseEvent e) {	
	}

	@Override
	public void mouseExited(MouseEvent e) {	
	}
}
