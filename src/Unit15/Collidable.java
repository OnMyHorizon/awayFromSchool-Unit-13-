package Unit15;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - 
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public interface Collidable
{
	public boolean didCollideLeft(Object obj);
	public boolean didCollideRight(Object obj);
	public boolean didCollideTop(Object obj);
	public boolean didCollideBottom(Object obj);
}