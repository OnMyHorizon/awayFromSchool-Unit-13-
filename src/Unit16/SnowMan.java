package Unit16;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class SnowMan extends AbstractShape
{
   public SnowMan(int x, int y, int w, int h )
   {
		super(x, y, w, h, Color.WHITE, 0, 0);
   }

   public void draw(Graphics window)
   {
	   window.setColor(Color.WHITE);
	   window.fillOval(getXPos(),getYPos(),getWidth(),getHeight());
	   window.fillOval(getXPos() + getWidth()/7,getYPos()-getHeight()/3,(2*getWidth())/3,(2*getHeight())/3);
	   window.fillOval(getXPos() + getWidth()/4,getYPos()-getHeight()/2,getWidth()/3,getHeight()/3);
   }
   public void moveAndDraw(Graphics window)
   {
      draw(window);   
   }
}