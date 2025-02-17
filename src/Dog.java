public class Dog extends Animal{
	/**This constructor initializes the Dog piece
	 * 
	 * @param c
	 */
	public Dog(boolean c) {
		super(4, c);
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
			}else if (newPos instanceof River) {
				return false;
			}else if(newPos instanceof Trap && newPos.isOccupied()) {
				if(canEatTrapped(curPos, newPos)) {
					b.updateBoard(curPos, newPos);
					return true;
				}else {
					return false;
				}
			}else if (newPos.isOccupied()) {
				if(curPos.getPieceOnTile().getRANK() < newPos.getPieceOnTile().getRANK()) {
					return false;
				}
				if(curPos.getPieceOnTile().isRed == newPos.getPieceOnTile().isRed) {
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
