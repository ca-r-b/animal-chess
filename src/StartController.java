import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("unused")
public class StartController implements MouseListener, ActionListener{
	private Board b;
	private Player[] p;
	
	private BoardView bv;
	private BoardController bc;
	
	private StartView sv;
	private ShuffledPieces sp;
	
	private int chosenByP1;
	private boolean isDone;
	
	public StartController(StartView sv, ShuffledPieces sp, Board b, Player[] p) {
		this.sv = sv;
		this.sp = sp;
		this.b = b;
		this.p = p;
		
		isDone = false;
		
		sv.setMouseListener(this);
		sv.setActionListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		ShuffleButton chosen = (ShuffleButton) e.getComponent();
		
		if(p[0].getIsTurnShuffle()) {
			p[0].selectPieceShuffle(sp, chosen.getPieceNum());
			
			chosenByP1 = chosen.getPieceNum();
			
			p[0].setIsTurnShuffle(false);
			p[1].setIsTurnShuffle(true);
			
			sv.setShuffleEnabled(chosen.getPieceNum(), false);
		}else if((p[1].getIsTurnShuffle()) && (chosen.getPieceNum() != chosenByP1)) {
			p[1].selectPieceShuffle(sp, chosen.getPieceNum());
			
			p[1].setIsTurnShuffle(false);
			
			sv.setShuffleEnabled(chosen.getPieceNum(), false);
		}
		
		if(p[1].getIsTurnShuffle()) {
			sv.setLblStatus("(PLAYER 2) SELECT AMONG THE RANDOMIZED PIECES!");
		}
		
		if((p[0].getIsTurnShuffle() == p[1].getIsTurnShuffle()) && !isDone) {
			String piece1 = sp.getAnimalType(p[0].getChosenShuffle());
			String piece2 = sp.getAnimalType(p[1].getChosenShuffle());
			
			sv.showChosenAnimal(piece1);
			sv.showChosenAnimal(piece2);
			
			sv.setAllShuffleEnabled(false);
			sv.setBtnEnabled(true);
			
			if(sp.decideFirstMove(p[0].getChosenShuffle(), p[1].getChosenShuffle())) {
				p[0].setIsTurn(true);
				p[1].setIsTurn(false);
				
				sv.setLblStatus("(PLAYER 1) YOU WILL HAVE THE FIRST MOVE! SELECT YOUR TEAM COLOR!");
			}else {
				p[0].setIsTurn(false);
				p[1].setIsTurn(true);
				
				sv.setLblStatus("(PLAYER 2) YOU WILL HAVE THE FIRST MOVE! SELECT YOUR TEAM COLOR!");
			}
			
			isDone = true;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("TEAM RED")) {
			
			if(p[0].getIsTurn()) {
				p[0].setIsRed(true);
				p[1].setIsRed(false);
			}else if(p[1].getIsTurn()) {
				p[0].setIsRed(false);
				p[1].setIsRed(true);
			}
			
			bv = new BoardView();
			bc = new BoardController(bv, b, p);
			
			sv.setBtnEnabled(false);
			sv.dispose();
			
		}else if(e.getActionCommand().equals("TEAM BLUE")) {
			
			if(p[0].getIsTurn()) {
				p[0].setIsRed(false);
				p[1].setIsRed(true);
			}else if(p[1].getIsTurn()) {
				p[0].setIsRed(true);
				p[1].setIsRed(false);
			}
			
			bv = new BoardView();
			bc = new BoardController(bv, b, p);
			
			sv.setBtnEnabled(false);
			sv.dispose();
			
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
