package finalproject;
import javax.swing.*;

public class button {
	public int xLoc, yLoc, width, height;
	protected JButton button;
	public button (int x, int y, int w, int h) {
		button = new JButton();
		button.setBounds(x,y,w,h);
		xLoc = x;
		yLoc = y;
		width = w;
		height = h;
	}
	public int getX() {
		return xLoc;
	}
	public int getY() {
		return yLoc;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public void setX(int x) {
		xLoc = x;
		button.setBounds(x,yLoc,width,height);
	}
	public void setY(int y) {
		yLoc = y;
		button.setBounds(xLoc,y,width,height);
	}
	public void setWidth(int w) {
		width = w;
		button.setBounds(xLoc,yLoc,w,height);
	}
	public void setHeight(int h) {
		height = h;
		button.setBounds(xLoc,yLoc,width,h);
	}
	public JButton renderButton() {
		return button;
	}
}
