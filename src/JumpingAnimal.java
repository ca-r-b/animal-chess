
public interface JumpingAnimal {
	
	/**This method checks if the jumping animal (LION & TIGER) is able to cross the river
	 * 
	 * @param b game board
	 * @param curPos current position of the animal piece of the player
	 * @param newPos new position of the animal piece of the player
	 * 
	 * @return true if the jumping animals can cross the river. Otherwise, false.
	 */
	public default boolean canJumpAcross(Board b, Tile curPos, Tile newPos) {
		
		if(!newPos.isOccupied() || ((curPos.getPieceOnTile().isRed != newPos.getPieceOnTile().isRed) 
						&& newPos.getPieceOnTile().getRANK() <= curPos.getPieceOnTile().getRANK())) {
			
			if((curPos.getYP() == 1 || curPos.getYP() == 2 ||curPos.getYP() == 4 || curPos.getYP() == 5) && (curPos.getXP() == 2 || curPos.getXP() == 6)) 
				if(Math.abs(curPos.getXP() - newPos.getXP()) == 4 && (curPos.getYP() == newPos.getYP()))
					if(!mouseInRiver(b, curPos, newPos, true))
						return true;
				
			if((curPos.getYP() == 0 || curPos.getYP() == 3 ||curPos.getYP() == 6) && (curPos.getXP() >= 3 && curPos.getXP() <= 5)) {
				
				if(Math.abs(curPos.getYP() - newPos.getYP()) == 3 && (curPos.getXP() == newPos.getXP()))
					if(!mouseInRiver(b, curPos, newPos, false))
						return true;
			}
			
		}
		
		return false;
	}
	
	/** This method checks if the there is a mouse in the river horizontally or vertically in relation to the chosen animal piece of the player
	 *  
	 * @param b game board
	 * @param cP current position of the animal piece of the player
	 * @param nP new  position of the animal piece of the player
	 * @param isHorizontal checks if the direction if horizontal
	 * 
	 * @return true if there is a mouse on the way of the move of the chosen animal piece of player
	 */
	public default boolean mouseInRiver(Board b, Tile cP, Tile nP, boolean isHorizontal) { //Fix
		Tile[][] temp = b.getTiles();
		
		if(isHorizontal) { // If horizontal to RIVER
			for (int i = 3; i < 6; i++) {
				if(temp[cP.getYP()][i].isOccupied())
					return true;
			}
		}else {	// If vertical to RIVER
			if((cP.getYP() == 0 && nP.getYP() == 3) || (cP.getYP() == 3 && nP.getYP() == 0)) {
				for (int i = 1; i < 3; i++) {
					if(temp[i][cP.getXP()].isOccupied())
						return true;
				}
			}
			if((cP.getYP() == 3 && nP.getYP() == 6) || (cP.getYP() == 6 && nP.getYP() == 3)) {
				for (int i = 4; i < 6; i++) {
					if(temp[i][cP.getXP()].isOccupied())
						return true;
				}
			}
		}
		
		return false;
	}
}
