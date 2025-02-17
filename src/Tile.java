public abstract class Tile {
	protected final int XP;
	protected final int YP;
	protected Animal pieceOnTile;

	/**This constructor initializes a tile that is not occupied 
	 * 
	 * @param y Y coordinate
	 * @param x X coordinate
	 */
	public Tile(int y, int x) {
		XP = x;
		YP = y;
		pieceOnTile = null;
	}
	
	/**This constructor initializes a tile that is occupied by an animal piece
	 * 
	 * @param y
	 * @param x
	 * @param p
	 */
	public Tile(int y, int x, Animal p) {
		XP = x;
		YP = y;
		pieceOnTile = p;
	}

	/**
	 * 
	 * @return X coordinate of the tile
	 */
	public int getXP() {
		return XP;
	}
	
	/**
	 * 
	 * @return Y coordinate of the tile
	 */
	public int getYP() {
		return YP;
	}
	
	/**
	 * 
	 * @return animal piece that is on the tile. Otherwise, returns null if tile is not occupied
	 */
	public Animal getPieceOnTile() {
		if (pieceOnTile != null)
			return pieceOnTile;

		return null;
	}
	
	/**This method sets the animal piece on the tile 
	 * 
	 * @param p animal piece to be set on tile
	 */
	public void setPieceOnTile(Animal p) {
		pieceOnTile = p;
	}
	
	/**This method removes the animal piece that is on the tile
	 * 
	 */
	public void removePiece() {
		System.out.println("Moved");
		pieceOnTile = null;
	}
	/**This method checks if the tile is occupied by an animal piece
	 * 
	 * @return false if the tile is not occupied. Otherwise, true.
	 */
	public boolean isOccupied() {
		if (pieceOnTile == null)
			return false;
		
		return true;
	}
}