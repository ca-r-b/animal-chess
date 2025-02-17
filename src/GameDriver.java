@SuppressWarnings("unused")
public class GameDriver {

	public static void main(String[] args) {
		
		Board b = new Board();
		Player[] p = new Player[2];
		ShuffledPieces sp = new ShuffledPieces();
		
		p[0] = new Player(true);
		p[1] = new Player(false);
		
		LauncherView lv = new LauncherView();		
		LauncherController lc = new LauncherController(lv, b, p, sp);
		
	}

}
