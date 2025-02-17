import javax.swing.event.*;
import java.awt.event.*;

@SuppressWarnings("unused")
public class LauncherController implements ActionListener {

	private LauncherView lv;

	private StartView sv;
	private StartController sc;
	
	private Board b;
	private Player[] p;
	private ShuffledPieces sp;
	
	public LauncherController(LauncherView lv, Board b, Player[] p, ShuffledPieces sp) {
		this.lv = lv;
		
		this.b = b;
		this.p = p;
		this.sp = sp;
		
		lv.setListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("PLAY")){
			lv.dispose();
			lv.setListener(null);
			
			sv = new StartView();
			sc = new StartController(sv, sp, b, p);
		}else if(e.getActionCommand().equals("INSTRUCTIONS")){
			
		}
	}

}
