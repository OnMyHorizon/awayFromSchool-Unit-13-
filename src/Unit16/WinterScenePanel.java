package Unit16;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class WinterScenePanel extends JPanel implements Runnable
{
	private List<AbstractShape> shapes;
	private AbstractShape sMan;
	private AbstractShape tree;
	private AbstractShape car;
	public WinterScenePanel()
	{
		setVisible(true);
		//refer shapes to a new ArrayList of AbstractShape
		shapes = new ArrayList<AbstractShape>();
		for (int i = 0; i < 50; i++) {
			int xpos = (int)((Math.random() * (730-40) +40));
			int ypos = (int)((Math.random() * (530-40) + 40));
			shapes.add(new FancySnowFlake(xpos,ypos,20,20, Color.white, 0, 5));
		}
		System.out.println(shapes.size());
		//populate the list with 50 unique snowflakes

		//instantiate a snowman
		sMan = new SnowMan(500, 400, 100, 100);
		tree = new Tree(100,400,30,300, Color.green);
		car = new Car(300, 200, 30,30, Color.red);
		new Thread(this).start();
	}

	public void update(Graphics window)
	{
		paint(window);
	}

	public void paint(Graphics window)
	{
		window.setColor(Color.BLUE);
		window.fillRect(0,0,getWidth(), getHeight());
		window.setColor(Color.WHITE);
		window.drawRect(20,20,getWidth()-40,getHeight()-40);
		window.setFont(new Font("TAHOMA",Font.BOLD,18));
		window.drawString("MAKE A WINTER SCENE!",40,40);

		//make the snowman appear
		sMan.draw(window);
		tree.draw(window);
		car.draw(window);
		//make the snowflakes appear and move down the screen
		for (AbstractShape s : shapes) {
			if (s.getYPos() > 530) {
				s.setYPos(40);
			}else {
				s.moveAndDraw(window);
			}
		}
	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(35);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}