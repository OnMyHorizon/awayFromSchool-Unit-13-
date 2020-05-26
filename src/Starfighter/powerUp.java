package Starfighter;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.util.List;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class powerUp extends MovingThing
{
	private int speed;
	private Image image;

	public powerUp()
	{
		this(10,10,10,10,10);
	}

	public powerUp(int x, int y)
	{
		this(x,y,100,100,5);
	}

	public powerUp(int x, int y, int s)
	{
		this(x,y,100,100,s);
	}

	public powerUp(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		speed=s;
		try
		{
			URL url = getClass().getResource("pu.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			System.out.println("Error locating the file");
		}
	}
	public powerUp(int x, int y, int w, int h)
	{
		super(x, y, w, h);
		try
		{
			URL url = getClass().getResource("pu.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			System.out.println("Error locating the file");
		}
	}
	public void move(String direction){
	}
	public void setSpeed(int s) {	
	}
	public int getSpeed() {
		return 0;
	}
	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}
	public boolean didCollideWithShip(Ship s) {
		if (s.getX() < this.getX() + 100 && s.getY() > this.getY() - 100) {
			return true;
		} else {
			return false;
		}
	}
	public String toString() {
		return "";
	}
}