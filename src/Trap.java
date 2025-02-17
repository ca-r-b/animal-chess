public class Trap extends Tile{
	private boolean isRed;
	
	/**This method initializes the Trap tile
	 * 
	 * @param x X coordinate
	 * @param y Y coordinate
	 * @param r color of the Trap
	 */
	public Trap(int x, int y, boolean r) {
		super(x, y);
		isRed = r;
	}
	/**This method checks if the Trap is a RED trap
	 * 
	 * @return true if the trap is red. Otherwise, false.
	 */
	public boolean getIsRed() {
		return isRed;
	}
	
}
