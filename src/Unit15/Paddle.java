package Unit15;
//(c) A+ Computer Science

//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block {
	// instance variables
	private int speed;

	public Paddle() {
		super(10, 10, 10, 50, Color.black);
		setSpeed(5);
	}

	// add the other Paddle constructors

	public Paddle(int x, int y) {
		super(x, y, 10, 50, Color.black);
		setSpeed(5);
	}

	public Paddle(int x, int y, int s) {
		super(x, y, 10, 50, Color.black);
		setSpeed(s);
	}

	public Paddle(int x, int y, int w, int h, int s) {
		super(x, y, w, h, Color.black);
		setSpeed(s);
	}

	public Paddle(int x, int y, int w, int h, Color c, int s) {
		super(x, y, w, h, c);
		setSpeed(s);
	}
	
	public void setSpeed(int spd) {
		speed = spd;
	}
	public void moveUpAndDraw(Graphics window) {
		draw(window,Color.white);
		setY(getY()-getSpeed());
		draw(window, getColor());
	}

	public void moveDownAndDraw(Graphics window) {
		draw(window,Color.white);
		setY(getY()+getSpeed());
		draw(window, getColor());
	}
	public void moveRightAndDraw(Graphics window) {
		draw(window,Color.white);
		setX(getX() +getSpeed());
		draw(window, getColor());
	}
	public void moveLeftAndDraw(Graphics window) {
		draw(window,Color.white);
		setX(getX() -getSpeed());
		draw(window, getColor());
	}

	// add get methods
	public int getSpeed() {
		return speed;
	}
	// add a toString() method
	public String toString(){
		return super.getX()+" "+super.getY()+" "+super.getWidth()+" "+super.getHeight()+" "+super.getColor()+ " " + getSpeed();
	}
}