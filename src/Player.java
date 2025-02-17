public class Player {
	private boolean isTurn;
	private boolean isRed;
	private boolean isTurnShuffle;
	private Animal chosenShuffle;
	
	/**This method initializes the players for the game
	 * 
	 * @param t
	 */
	public Player(boolean t) {
		isTurnShuffle = t;
	}
	
	
	public void setIsTurn(boolean t) {
		isTurn = t;
	}
	
	public void setIsRed(boolean r) {
		isRed = r;
	}
	
	public void setIsTurnShuffle(boolean t) {
		isTurnShuffle = t;
	}
	
	public boolean getIsTurn() {
		return isTurn;
	}
	
	public boolean getIsRed() {
		return isRed;
	}
	
	public boolean getIsTurnShuffle() {
		return isTurnShuffle;
	}
	
	public Animal getChosenShuffle() {
		return chosenShuffle;
	}
	
	public void selectPieceShuffle(ShuffledPieces sp, int i) {
		chosenShuffle = sp.getChosenPiece(i);
	}
	
	public boolean selectPiece(Board b, int curY, int curX) {
		Tile[][] temp = b.getTiles();
		
		if(!temp[curY][curX].isOccupied()) {
			return false; // If tile does not have a piece on top
		}
		
		if(temp[curY][curX].getPieceOnTile().isRed != getIsRed()) {
			return false; // If piece is not on the same team
		}
		
		return true; 
	}
	
	public boolean movePiece(Board b, int curY, int curX, int newY, int newX) {
		Tile[][] temp = b.getTiles();
		
		if(temp[curY][curX].getPieceOnTile().canExecuteMove(b, temp[curY][curX], temp[newY][newX])) {
			return true;
		}
		
		return false;
	}
}
