package finalproject;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
public class imageButton extends button{
	private JButton buttonImage;
	private Image image;
	public imageButton(int x, int y, int w, int h, String n) {
		super(x,y,w,h);
		try
		{
			URL url = getClass().getResource(n+ ".jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			System.out.println("Error locating the file");
		}
		Icon icon = new ImageIcon(image);
		buttonImage = new JButton(icon);
		buttonImage.setBounds(button.getBounds());
	}
	@Override
	public JButton renderButton() {
		return buttonImage;
	}
	public Icon getNewIcon(String n) {
		try
		{
			URL url = getClass().getResource(n+ ".jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			System.out.println("Error locating the file");
		}
		Icon icon = new ImageIcon(image);
		return icon;
	}
}
