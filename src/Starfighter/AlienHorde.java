package Starfighter;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
	private List<Alien> aliens;
	private boolean right = true;
	private boolean left = false;
	private boolean down = true;
	private int sze;
	public AlienHorde(int size)
	{
		sze = size;
		aliens = new ArrayList<Alien>();
	}
	public void generateHorde(int x, int y, int w, int h, int s) {
		int xPos = x;
		for (int i = 0; i < sze; i++) {
			aliens.add(new Alien(x, y, w, h, s));
			if (x >= 600) {
				x = xPos;
				y = y + 10 + h;
			} else {
				x = x + w + 10;
			}
		}
	}
	public void add(Alien al)
	{
		aliens.add(al);
	}

	public void drawEmAll( Graphics window )
	{
		if (sze > 0) {
		for (Alien a : aliens) {
			a.draw(window);
		}
		}
	}

	public void moveEmAll()
	{
		if (sze > 0) {
		if (aliens.get(0).getX() <= 0) {
			right = true;
			left = false;
			down = true;
		} else if (aliens.get(aliens.size() - 1).getX()
				+ aliens.get(aliens.size() - 1).getWidth() >= 800 - 18) {
			right = false;
			left = true;
			down = true;
		}
		if (right == true) {
			for (Alien a : aliens) {
				a.move("RIGHT");
			}
		} else {
			for (Alien a : aliens) {
				a.move("LEFT");
			}
		}
		if (down == true) {
			for (Alien a : aliens) {
				a.move("DOWN");
				a.move("DOWN");
				a.move("DOWN");
				a.move("DOWN");
			}
			down = false;
		}
		}
	}

	public void removeDeadOnes(List<Ammo> shots)
	{
		for (int i = 0; i < aliens.size(); i++) {
			if (shots.size() > 0) {
				for (int j = 0; j < shots.size(); j++) {
					if (shots.get(j).didCollide(aliens.get(i))) {
						sze --;
						aliens.remove(i);
						i = 0;
						break;
					}
				}
			}
		}
	}
	public int getSize() {
		return sze;
	}
	public List<Alien> getList(){
		return aliens;
	}
	public String toString()
	{
		return "";
	}
}
