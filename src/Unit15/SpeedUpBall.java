package Unit15;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball
{

   //instance variables

   public SpeedUpBall()
   {
	   super();
   }

   public SpeedUpBall(int x, int y)
   {
	   super(x,y);
   }


   public SpeedUpBall(int x, int y, int xSpd, int ySpd)
   {
	   super(x, y, xSpd, ySpd);
   }

   public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {
	   super(x, y, wid, ht, xSpd, ySpd);
   }


   public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
	   super(x, y, wid, ht, col, xSpd, ySpd);
   }

   public void setXSpeed( int xSpd )
   {
	   if(xSpd != 0) {
		   int amt = 1;
		   if (xSpd < 0) {
			   amt = -1;
		   }
		   super.setXSpeed(xSpd + amt);
	   }else {
		   super.setXSpeed(0);
	   }
   }

   public void setYSpeed( int ySpd )
   {
	   if (ySpd != 0) {
		   int amt = 1;
		   if (ySpd < 0) {
			   amt = -1;
		   }
		   super.setYSpeed(ySpd + amt);
	   }else {
		   super.setYSpeed(0);
	   }
   }
}

