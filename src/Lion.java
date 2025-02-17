public class Lion extends Animal implements JumpingAnimal{
	/**This method initializes the Lion piece
	 * 
	 * @param c
	 */
	public Lion(boolean c) {
		super(7, c);
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
				if(curPos.getPieceOnTile().isRed == newPos.getPieceOnTile().isRed) {
					return false;
				}
				if(curPos.getPieceOnTile().getRANK() < newPos.getPieceOnTile().getRANK()) {
					return false;
				}
			}	
		}else if(!canJumpAcross(b, curPos, newPos)) {
			return false;
		}
		
		b.updateBoard(curPos, newPos);
		return true;
	}
	
	
	@Override
	/**This method checks if the jumping animal (LION & TIGER) is able to cross the river
	 * 
	 * @param b game board
	 * @param curPos current position of the animal piece of the player
	 * @param newPos new position of the animal piece of the player
	 * 
	 * @return true if the jumping animals can cross the river. Otherwise, false.
	 */
	public boolean canJumpAcross(Board b, Tile curPos, Tile newPos) {
		return JumpingAnimal.super.canJumpAcross(b, curPos, newPos);
	}
}
