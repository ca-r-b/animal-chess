public class Den extends Tile{
	private boolean isRed;
	/**This method initializes the Den
	 * 
	 * @param y Y coordinate
	 * @param x X coordinate
	 * @param r color of the Den
	 */
	public Den(int y, int x, boolean r) {
		super(y, x);
		isRed = r;
	}
	
	/**This method checks the if the color of the den is red
	 *  
	 * @return true if the color of the Den is red. Otherwise, false.
	 */
	public boolean getColor() {
		return isRed;
	}
}
