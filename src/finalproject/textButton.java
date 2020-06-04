package finalproject;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
public class textButton extends button{
	private JButton buttonText;
	private Image image;
	public textButton(int x, int y, int w, int h, String t) {
		super(x,y,w,h);
		buttonText = new JButton(t);
		buttonText.setBounds(button.getBounds());
	}
	@Override
	public JButton renderButton() {
		return buttonText;
	}
}
