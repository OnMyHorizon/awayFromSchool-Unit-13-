package Starfighter;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Font;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
	private Alien alienOne;
	private Alien alienTwo;
	private Ammo a;
    private AlienHorde horde;
	private Bullets shots;
	private downBullets downShots;
	private boolean generatedAliens;
	private boolean[] keys;
	private BufferedImage back;
	private int delay;
	private boolean gameOver;
	private powerUp pu;
	private boolean puActive;
	private boolean shipPuActive;
	public OuterSpace()
	{
		shipPuActive = false;
		puActive = false;
		gameOver = false;
		pu = new powerUp(100, 400, 100, 100);
		setBackground(Color.black);
		generatedAliens = false;
		keys = new boolean[5];
		horde = new AlienHorde(10);
		shots = new Bullets();
		ship = new Ship(350, 400, 100, 100, 3);
		alienOne = new Alien(200,50);
		alienTwo = new Alien(250,50);
		downShots = new downBullets();
		a = new Ammo((ship.getX() + ship.getWidth() / 2) - 5, ship.getY() - 5, 5);
		//instantiate other instance variables
		//Ship, Alien

		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();
		if (!gameOver) {
		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);
		if (generatedAliens == false) {
			horde.generateHorde(115, 35, 40, 40, 1);
			generatedAliens = true;
		}
		if(keys[0] == true && ship.getX() > 0)
		{
			ship.move("LEFT");
		}
		if(keys[1] == true && ship.getX() < 800 -100) {
			ship.move("RIGHT");
		}
		if(keys[2] == true && ship.getY() > 0) {
			ship.move("UP");
		}
		if(keys[3] == true && ship.getY() < 600 - 150) {
			ship.move("DOWN");
		}
		if(keys[4] == true && delay > 20) {
			delay = 0;
			shots.add(new Ammo((ship.getX() + ship.getWidth() / 2) - 5, ship.getY() - 5, 5));
		}
		Random r = new Random();
		if (r.nextInt(1000) > 995 && horde.getSize() > 0) {
			Alien shooting = horde.getList().get(r.nextInt(horde.getSize()));
			downShots.add(new Ammo((shooting.getX() + shooting.getWidth() / 2) - 5, shooting.getY() + 20, 2));
		}
		if (r.nextInt(1000) > 900 && !shipPuActive) {
			puActive = true;
		}
		if (pu.didCollideWithShip(ship) && puActive) {
			puActive = false;
			shipPuActive = true;
		}
		}
		//add code to move Ship, Alien, etc.
		//a.move("UP");
		//add in collision detection to see if Bullets hit the Aliens and if Bullets hit the Ship
		//if (a.isActive()) {
			//a.draw(graphToBack);
		//}
		//if (!a.didCollide(alienOne)) {
			//alienOne.draw(graphToBack);
		//}
		//if (!a.didCollide(alienTwo)) {
			//alienTwo.draw(graphToBack);
		//}
		if (downShots.getList().size() > 0 && horde.getSize() > 0) {
			for (int j = 0; j < downShots.getList().size(); j++) {
				if (downShots.getList().get(j).didCollideWithShip(ship)) {
					if (!shipPuActive) {
						gameOver = true;
						graphToBack.setColor(Color.BLACK);
						graphToBack.fillRect(0,0,800,600);
						graphToBack.setColor(Color.BLUE);
						Font f = new Font("Serif", Font.BOLD, 30);
						graphToBack.setFont(f);
						graphToBack.drawString("You loose!", 300, 300 );
					}else {
						shipPuActive = false;
					}
				}
			}
		}
		if (horde.getSize() <= 0) {
			gameOver = true;
			graphToBack.setColor(Color.BLACK);
			graphToBack.fillRect(0,0,800,600);
			graphToBack.setColor(Color.BLUE);
			Font f = new Font("Serif", Font.BOLD, 30);
			graphToBack.setFont(f);
			graphToBack.drawString("You Win!", 300, 300 );
		}
		if (!gameOver) {
			if (puActive) {
				pu.draw(graphToBack);
			}
			delay ++;
			shots.drawEmAll(graphToBack);
			shots.moveEmAll();
			horde.drawEmAll(graphToBack);
			ship.draw(graphToBack);
			horde.moveEmAll();
			horde.removeDeadOnes(shots.getList());
			shots.cleanEmUp();
			if (shipPuActive) {
				ship.puNotActive();
			}else {
				ship.puActive();
			}
			ship.draw(graphToBack);
			downShots.drawEmAll(graphToBack);
			downShots.moveEmAll();
			downShots.cleanEmUp();
		}
		twoDGraph.drawImage(back, null, 0, 0);
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{
      //no code needed here
	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}

