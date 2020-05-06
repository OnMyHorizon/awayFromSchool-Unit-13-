package Unit16;

import java.awt.Color;
import java.awt.*;
import java.awt.Polygon;
import java.awt.Graphics;

public class Car extends AbstractShape{
	public Car (int x, int y, int w, int h, Color c) {
		super(x,y,w,h,c);
	}
	public void draw(Graphics window){
		Polygon p = new Polygon();
		p.addPoint(getXPos() +15, getYPos());
		p.addPoint(getXPos() + 35, getYPos() - 30);
		p.addPoint(getXPos() + 95, getYPos() - 30);
		p.addPoint(getXPos() +115, getYPos());
		window.setColor(getColor());
		window.fillPolygon(p);
		window.setColor(Color.black);
		window.fillOval(getXPos(), getYPos(), getWidth(), getHeight());
		window.fillOval(getXPos() +100, getYPos(), getWidth(), getHeight());
		window.fillRect(getXPos() +70, getYPos()- 25, 20, 20);
	}
	public void moveAndDraw(Graphics window){
		draw(window); 
	}
}
