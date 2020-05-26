package Starfighter;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ammo extends MovingThing
{
	private int speed;
	private boolean active = true;
	public Ammo()
	{
		this(0,0,0);
	}

	public Ammo(int x, int y)
	{
		this(x, y, 5);
	}

	public Ammo(int x, int y, int s)
	{
		super(x, y);
		speed = s;
	}

	public void setSpeed(int s)
	{
		speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
		window.setColor(Color.yellow);
		window.fillRect(getX(), getY(), 10, 10);
	}
	
	
	public void move( String direction )
	{
		if (direction.equals("RIGHT")){
			setX(getX() + speed);
		}
		if (direction.equals("LEFT")){
			setX(getX() - speed);
		}
		if (direction.equals("UP")){
			setY(getY() - speed);
		}
		if (direction.equals("DOWN")){
			setY(getY() + speed);
		}
	}

	public String toString()
	{
		return "";
	}
	public boolean didCollide(Alien al) {
		if (getX() + 10 >= al.getX() && getX() <= al.getX() + al.getWidth()
				&& getY() - 10 >= al.getY()
				&& getY() <= al.getY() + al.getHeight()) {
			remove();
			return true;
		} else {
			return false;
		}
	}
	public boolean didCollideWithShip(Ship s) {
		if (getX() + 10 >= s.getX() && getX() <= s.getX() + s.getWidth()
				&& getY() - 10 >= s.getY()
				&& getY() <= s.getY() + s.getHeight()) {
			remove();
			return true;
		} else {
			return false;
		}
	}

	public boolean isActive() {
		if (getY() < 0) {
			remove();
		}
		return active;
	}

	public void remove() {
		active = false;
	}
}
