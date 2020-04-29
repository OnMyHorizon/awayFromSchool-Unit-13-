package Unit15;
import java.awt.Color;

public class InvisibleBall extends Ball {
	private int time;
	private Color color;
	public InvisibleBall(){
		super();
		invisibility();
	}
	public InvisibleBall(int x, int y){
		super(x, y);
		invisibility();
	}
	public InvisibleBall(int x, int y, int xSpd, int ySpeed){
		super(x, y, xSpd, ySpeed);
		invisibility();
	}
	public InvisibleBall(int x, int y, int width, int height, int xSpd, int ySpeed){
		super(x, y, width, height, xSpd, ySpeed);
		invisibility();
	}
	public InvisibleBall(int x, int y, int width, int height, Color col, int xSpeed, int ySpeed){
		super(x, y, width, height, col, xSpeed, ySpeed);
		invisibility();
	}
	private void invisibility(){
		Thread timer = new Thread(() -> {
		boolean invisible = true;
		color = this.getColor();
			while (true){
				invisible = !invisible;
				time = 1000 + (int)(4000 * Math.random());
				if (invisible == true){
					this.setColor(Color.WHITE);
				}else{
					this.setColor(color);
				}
				try{
					Thread.sleep(time);
				} catch (InterruptedException e){
					e.printStackTrace();
				}
			}
		});
		timer.start();
	}
}