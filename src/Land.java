public class Land extends Tile{
	/**This constructor initializes the Land tile 
	 * 
	 * @param y Y coordinate
	 * @param x X coordinate
	 */
	public Land(int y, int x) {
		super(y, x);
	}
	
	/**This method initialized the Land tile that is occupied by an animal piece
	 * 
	 * @param y Y coordinate
	 * @param x X coordinate
	 * @param p animal piece to be set on the Land tile
	 */
	public Land(int y, int x, Animal p) {
		super(y, x, p);
	}
}