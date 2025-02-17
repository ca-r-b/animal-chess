public abstract class Animal {
	protected final int RANK;
	protected boolean isRed;
	/**This method initializes an animal piece
	 * 
	 * @param r rank of the animal piece
	 * @param c color of the animal piece
	 */
	public Animal(int r, boolean c) {
		RANK = r;
		isRed = c;
	}

	/**This method returns the rank of the animal piece
	 * 
	 * @return rank of the animal piece
	 */
	public int getRANK() {
		return RANK;
	}
	
	/**
	 * 
	 * @return true if the animal piece's team color is red. Otherwise, false.
	 */
	public boolean getIsRed() {
		return isRed;
	}
	
	/**This method checks if the move of the player is one block away from the initial position of the player's chosen piece
	 * 
	 * @param curPos current position of the animal piece of the player
	 * @param newPos new position of the animal piece of the player
	 * 
	 * @return true if the move of the player is one block away from the current position of the player's chosen piece. Otherwise, false.
	 */
	public boolean isOneBlockAway(Tile curPos, Tile newPos) {
		if((Math.abs(curPos.getXP() - newPos.getXP()) == 1 && curPos.getYP() == newPos.getYP()) 
				|| (Math.abs(curPos.getYP() - newPos.getYP()) == 1 && curPos.getXP() == newPos.getXP())) {
			return true;
		}
		return false;
	}
	
	/** This method checks if the chosen animal piece of the player can eat the trapped animal 
	 * 
	 * @param curPos curPos current position of the animal piece of the player
	 * @param newPos newPos new position of the animal piece of the player
	 * @return true if the player's chosen animal piece can eat the opponent's trapped animal piece. Otherwise, false.
	 */
	public boolean canEatTrapped(Tile curPos, Tile newPos) {
		if(((Trap)newPos).getIsRed() == curPos.getPieceOnTile().getIsRed()) {
			if(curPos.getPieceOnTile().isRed != newPos.getPieceOnTile().isRed) {
				return true;
			}		
		}
		if((curPos.getPieceOnTile().getIsRed() == newPos.getPieceOnTile().getIsRed())) {
			return false;
		}
		if(((Trap)newPos).getIsRed() != curPos.getPieceOnTile().getIsRed()){
				return false;
		}
		return false;
	}
	/**This method checks if the move of the player is valid
	 * 
	 * @param b game board
	 * @param curPos curPos current position of the animal piece of the player
	 * @param newPos newPos new position of the animal piece of the player
	 * 
	 * @return true if the player's move is valid. Otherwise, false.
	 */
	public abstract boolean canExecuteMove(Board b, Tile curPos, Tile newPos); //Check if they can move
}