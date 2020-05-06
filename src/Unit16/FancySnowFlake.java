package Unit16;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Polygon;

//extend the AbstractShape class to make a FancySnowFlake class
public class FancySnowFlake extends AbstractShape
{
	public FancySnowFlake(int x, int y, int w, int h, Color c, int xspd, int yspd) {
		super(x,y,w,h,c,xspd,yspd);
	}
	public void draw(Graphics window)
	{
		window.setFont(new Font("TimesRoman", Font.PLAIN, this.getWidth()*4));
		Polygon p = new Polygon();
		p.addPoint(this.getXPos(), this.getYPos());
		p.addPoint(this.getXPos() + this.getWidth(), this.getYPos()+getHeight());
		p.addPoint(this.getXPos() + (2 *this.getWidth()), this.getYPos());
		p.addPoint(this.getXPos() + this.getWidth(), this.getYPos()-getHeight());
		Polygon p1 = new Polygon();
		p1.addPoint(this.getXPos()+this.getWidth()/5, this.getYPos());
		p1.addPoint(this.getXPos() + this.getWidth(), this.getYPos()+getHeight() - getHeight()/5);
		p1.addPoint(this.getXPos() + (2 *this.getWidth()) - this.getWidth()/5, this.getYPos());
		p1.addPoint(this.getXPos() + this.getWidth(), this.getYPos()-getHeight() + getHeight()/5);
		Polygon p2 = new Polygon();
		p1.addPoint(this.getXPos()+this.getWidth()/2, this.getYPos());
		p1.addPoint(this.getXPos() + this.getWidth(), this.getYPos()+getHeight() - getHeight()/2);
		p1.addPoint(this.getXPos() + (2 *this.getWidth()) - this.getWidth()/2, this.getYPos());
		p1.addPoint(this.getXPos() + this.getWidth(), this.getYPos()-getHeight() + getHeight()/2);
		window.drawPolygon(p);
		window.drawPolygon(p1);
		window.drawPolygon(p2);
		//window.drawPolygon(p3);
		window.setColor(getColor());
		window.fillOval(this.getXPos() + this.getWidth()/2, this.getYPos() - getHeight()/2, this.getWidth(), getHeight());
		window.drawString("+", this.getXPos() + this.getWidth()/100, this.getYPos() + getHeight()+getHeight()/3);
	}
	public void moveAndDraw(Graphics window)
	{
		setYPos(getYPos() + getYSpeed());
	    draw(window);   
	}
}

