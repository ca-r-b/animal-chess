public class Board {
	private Tile[][] tiles;

	/**This constructor initializes the board for the game
	 * 
	 */
	public Board() {
		tiles = new Tile[7][9];
		setupBoard();
	}
	
	/**This method initializes and sets up the board and pieces that would be used in the game
	 * 
	 */
	public void setupBoard() {	
		// Set first to normal tiles
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 9; j++) {
				tiles[i][j] = new Land(i, j);
			}
		}
		
		// Set Dens
		tiles[3][0] = new Den(3, 0, true);
		tiles[3][8] = new Den(3, 8, false);
		
		// Set Traps
		tiles[2][0] = new Trap(2, 0, true);		// Red
		tiles[3][1] = new Trap(3, 1, true);
		tiles[4][0] = new Trap(4, 0, true);
		
		tiles[2][8] = new Trap(2, 8, false);	// Blue
		tiles[3][7] = new Trap(3, 7, false);
		tiles[4][8] = new Trap(4, 8, false);
		
		// Set Rivers
		tiles[1][3] = new River(1, 3);
		tiles[1][4] = new River(1, 4);
		tiles[1][5] = new River(1, 5);

		tiles[2][3] = new River(2, 3);
		tiles[2][4] = new River(2, 4);
		tiles[2][5] = new River(2, 5);

		tiles[4][3] = new River(4, 3);
		tiles[4][4] = new River(4, 4);
		tiles[4][5] = new River(4, 5);

		tiles[5][3] = new River(5, 3);
		tiles[5][4] = new River(5, 4);
		tiles[5][5] = new River(5, 5);
	
		// Set Red Animals
		tiles[6][2] = new Land(6, 2, new Mouse(true)); // 6 2
		tiles[1][1] = new Land(1, 1, new Cat(true));
		tiles[2][2] = new Land(2, 2, new Wolf(true));
		tiles[5][1] = new Land(5, 1, new Dog(true));
		tiles[4][2] = new Land(4, 2, new Leopard(true));
		tiles[0][0] = new Land(0, 0, new Tiger(true));
		tiles[6][0] = new Land(6, 0, new Lion(true));
		tiles[0][2] = new Land(0, 2, new Elephant(true));
		
		// Set Blue Animals
		tiles[0][6] = new Land(0, 6, new Mouse(false)); // 0 6
		tiles[5][7] = new Land(5, 7, new Cat(false)); // 5 7
		tiles[4][6] = new Land(4, 6, new Wolf(false)); // 4 6
		tiles[1][7] = new Land(1, 7, new Dog(false));
		tiles[2][6] = new Land(2, 6, new Leopard(false)); // 2 6
		tiles[6][8] = new Land(6, 8, new Tiger(false));
		tiles[0][8] = new Land(0, 8, new Lion(false)); // 0 8
		tiles[6][6] = new Land(6, 6, new Elephant(false));
	}
	
	/**This method uses the player's move to update the board
	 * 
	 * @param curPos curPos current position of the animal piece of the player
	 * @param newPos newPos new position of the animal piece of the player
	 */
	public void updateBoard(Tile curPos, Tile newPos) {
		tiles[newPos.getYP()][newPos.getXP()].setPieceOnTile(curPos.getPieceOnTile());
		tiles[curPos.getYP()][curPos.getXP()].removePiece();
	}
	
	/**This method returns the 2D array of tiles
	 * 
	 * @return 2D array of tiles
	 */
	public Tile[][] getTiles() {
		return tiles;
	}
	
	/**This method checks the number of animal pieces of team BLUE
	 * 
	 * @return true if there are no more animal pieces for team BLUE. Otherwise, false.
	 */
	public boolean checkBluePieces() {
		int counter = 0;
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 9; j++) {
				if(tiles[i][j].isOccupied())
					if(!tiles[i][j].getPieceOnTile().isRed)
						counter++;
			}
		}
		
		System.out.println("PIECES COUNT (BLUE): " + counter);
		
		if(counter == 0)
			return true;
					
		return false;
	}

	/**This method checks the number of animal pieces of team RED
	 * 
	 * @return true if there are no more animal pieces for team RED. Otherwise, false.
	 */
	public boolean checkRedPieces() {
		int counter = 0;
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 9; j++) {
				if(tiles[i][j].isOccupied())
					if(tiles[i][j].getPieceOnTile().isRed)
						counter++;
			}
		}
		
		System.out.println("PIECES COUNT (RED): " + counter);
		
		if(counter == 0)
			return true;
					
		return false;
	}
	
	/**This method checks if there is an opponent's piece on the BLUE DEN
	 *  
	 * @return true if BLUE DEN is occupied by an opponent's piece
	 */
	public boolean checkBlueDen() {
		if(tiles[3][8].isOccupied())
			if(tiles[3][8].getPieceOnTile().getIsRed())
				return true;
		
		return false;
	}

	/**This method checks if there is an opponent's piece on the RED DEN
	 *  
	 * @return true if RED DEN is occupied by an opponent's piece
	 */
	public boolean checkRedDen() {
		if(tiles[3][0].isOccupied())
			if(!tiles[3][0].getPieceOnTile().getIsRed())
				return true;
		
		return false;
	}
}