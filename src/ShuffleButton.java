import javax.swing.*;

@SuppressWarnings("serial")
public class ShuffleButton extends JButton{
	private int pieceNum; // Pang kuha index
	
	public ShuffleButton(int i) {
		pieceNum = i;
	}
	
	public int getPieceNum() {
		return pieceNum;
	}
}
