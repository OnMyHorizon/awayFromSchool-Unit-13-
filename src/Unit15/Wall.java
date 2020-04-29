package Unit15;

import java.awt.Color;

public class Wall extends Block {
	public Wall(int x, int y, int length, boolean horizontal) {
		super(x, y, 0, 0, Color.BLACK);
		
		if (horizontal == true){
			setWidth(length);
			setHeight(10);
		}
		if (horizontal == false){
			setWidth(10);
			setHeight(length);
		}
	}
}