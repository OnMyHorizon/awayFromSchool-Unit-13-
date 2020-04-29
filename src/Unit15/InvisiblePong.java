package Unit15;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import java.awt.event.ActionListener;

public class InvisiblePong extends Canvas implements KeyListener, Runnable {
	private Ball ball;
	private Paddle leftPaddle, rightPaddle;
	private boolean[] keys;
	private Wall top, bottom, left, right;
	private BufferedImage back;
	private int leftScore, rightScore;

	public InvisiblePong() {
		rightScore = 0;
		leftScore = 0;
		// ball
		ball = new InvisibleBall();
		// paddles
		leftPaddle = new Paddle(30, 10, 10, 100, 4);
		rightPaddle = new Paddle(775, 10, 10, 100, 4);
		// walls
		top = new Wall(0, 0, 820, true);
		bottom = new Wall(0, 610, 800 + 20, true);
		left = new Wall(0, 10, 600, false);
		right = new Wall(810, 10, 600, false);
		keys = new boolean[5];
		setBackground(Color.WHITE);
		setVisible(true);
		this.addKeyListener(this);
		new Thread(this).start();
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		Graphics2D twoDGraph = (Graphics2D) window;
		back = (BufferedImage) (createImage(getWidth(), getHeight()));
		Graphics graphToBack = back.createGraphics();
		// ball
		ball.moveAndDraw(graphToBack);
		// paddles
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);
		// walls
		top.draw(graphToBack);
		bottom.draw(graphToBack);
		left.draw(graphToBack);
		right.draw(graphToBack);
		// ball collisions
		if (ball.didCollideBottom(top) || ball.didCollideTop(bottom)) {
			ball.setYSpeed(-ball.getYSpeed());
		} 
		else if (ball.didCollideTop(leftPaddle) || ball.didCollideBottom(leftPaddle)
				|| ball.didCollideTop(rightPaddle) || ball.didCollideBottom(rightPaddle)) {
			ball.setYSpeed(-ball.getYSpeed());
		}
		if (ball.didCollideLeft(left)) {
			ball.setXSpeed(-ball.getXSpeed());
			rightScore++;
		}
		if (ball.didCollideRight(right)) {
			ball.setXSpeed(-ball.getXSpeed());
			leftScore++;
		} 
		else if (ball.didCollideLeft(leftPaddle) || ball.didCollideRight(leftPaddle)
				|| ball.didCollideLeft(rightPaddle) || ball.didCollideRight(rightPaddle)) {
			ball.setXSpeed(-ball.getXSpeed());
		}
		if (keys[0] == true && leftPaddle.getY() > 10) {
			leftPaddle.moveUpAndDraw(window);
		}
		if (keys[1] == true && leftPaddle.getY() < 510) {
			leftPaddle.moveDownAndDraw(window);
		}

		if (keys[2] == true && rightPaddle.getY() > 10) {
			rightPaddle.moveUpAndDraw(window);
		}
		if (keys[3] == true && rightPaddle.getY() < 510) {
			rightPaddle.moveDownAndDraw(window);
		}
		twoDGraph.drawImage(back, null, 0, 0);
		twoDGraph.drawString("Leftscore: " + Integer.toString(leftScore), 120, 650);
		twoDGraph.drawString("Rightscore: " + Integer.toString(rightScore), 20, 650);
	}

	public void keyPressed(KeyEvent e) {
		switch (toUpperCase(e.getKeyChar())) {
		case 'W':
			keys[0] = true;
			break;
		case 'Z':
			keys[1] = true;
			break;
		case 'I':
			keys[2] = true;
			break;
		case 'M':
			keys[3] = true;
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (toUpperCase(e.getKeyChar())) {
		case 'W':
			keys[0] = false;
			break;
		case 'Z':
			keys[1] = false;
			break;
		case 'I':
			keys[2] = false;
			break;
		case 'M':
			keys[3] = false;
			break;
		}
	}

	public void keyTyped(KeyEvent e) {

	}

	public void run() {
		try {
			while (true) {
				Thread.currentThread().sleep(8);
				repaint();
			}
		} catch (Exception e) {
		}
	}
}