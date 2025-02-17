public class Mouse extends Animal {
	/**This method initializes the Mouse piece
	 * 
	 * @param c
	 */
	public Mouse(boolean c) {
		super(1, c);
	}
	
	/**This method checks if the move of the player is valid
	 * 
	 * @param b game board
	 * @param curPos curPos current position of the animal piece of the player
	 * @param newPos newPos new position of the animal piece of the player
	 * 
	 * @return true if the player's move is valid. Otherwise, false.
	 */
	public boolean canExecuteMove(Board b, Tile curPos, Tile newPos) {
		if (isOneBlockAway(curPos, newPos)) {
			if (newPos instanceof Den) {
				if (((Den)newPos).getColor() == curPos.getPieceOnTile().getIsRed())
					return false;
			}else if(newPos instanceof Trap && newPos.isOccupied()) {
				if(canEatTrapped(curPos, newPos)) {
					b.updateBoard(curPos, newPos);
					return true;
				}else {
					return false;
				}
			}else if (newPos.isOccupied()) {
				if(curPos instanceof River && newPos instanceof Land) {
					return false;
				}else if(curPos instanceof River && newPos instanceof River) {
					b.updateBoard(curPos, newPos);
					return true;
				}else if(newPos.getPieceOnTile() instanceof Elephant && (curPos.getPieceOnTile().isRed != newPos.getPieceOnTile().isRed)) {
					b.updateBoard(curPos, newPos);
					return true;
				}else if (curPos.getPieceOnTile().isRed == newPos.getPieceOnTile().isRed) {
					return false;
				}else if (!(newPos.getPieceOnTile() instanceof Elephant) || !(newPos.getPieceOnTile() instanceof Mouse)) {
					return false;
				}
			}
		}else {
			return false;
		}
	
		b.updateBoard(curPos, newPos);
	
		return true;
	}
	
}
