import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class TileButton extends JButton{
	private final int XP;
	private final int YP;
	private String fileLoc;
	private ImageIcon btnIcon;
	
	public TileButton(int y, int x) {
		XP = x;
		YP = y;
		
		super.setBackground(Color.WHITE);
		
		fileLoc = null;
		btnIcon = null;
	}
	
	public TileButton(int y, int x, String f) {
		XP = x;
		YP = y;
		fileLoc = f;
		btnIcon = new ImageIcon(f);
		
		super.setBackground(Color.WHITE);
		super.setIcon(btnIcon);
	}
	
	public void setBtnIcon(ImageIcon btnIcon) {
		this.btnIcon = btnIcon;
		super.setIcon(btnIcon);
	}

	public int getXP() {
		return XP;
	}

	public int getYP() {
		return YP;
	}
	
	public String getFileLoc() {
		return fileLoc;
	}
	
	public ImageIcon getBtnIcon() {
		return btnIcon;
	}
	
	public void setFileLoc(String fileLoc) {
		this.fileLoc = fileLoc;
	}
	
	public void refresh() {
		super.setIcon(btnIcon);
	}
}
