package Unit15;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.event.KeyListener;

import java.awt.event.KeyEvent;
import static java.lang.Character.*;

public class SpeedUpPong extends Canvas implements KeyListener, Runnable {
	private Ball ball;
	private Paddle leftPaddle, rightPaddle;
	private boolean[] keys; // keeps track of what keys are pressed
	
	private Wall top, bottom, left, right;

	public SpeedUpPong() {
		//ball
		ball = new SpeedUpBall();
		//paddles
		leftPaddle = new Paddle(30, 10, 10, 100, 4);
		rightPaddle = new Paddle(775, 10, 10, 100, 4);
		//walls
		top = new Wall(0, 0, 800+20, true);
		bottom = new Wall(0, 600 + 10, 800+20, true);
		left = new Wall(0, 10, 600, false);
		right = new Wall(10 + 800, 10, 600, false);

		keys = new boolean[5];

		// set up the Canvas
		setBackground(Color.WHITE);
		setVisible(true);

		this.addKeyListener(this);
		new Thread(this).start();
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		//ball
		ball.moveAndDraw(window);
		//paddles
		leftPaddle.draw(window);
		rightPaddle.draw(window);
		//walls
		top.draw(window);
		bottom.draw(window);
		left.draw(window);
		right.draw(window);
		//ball collisions
		if (ball.didCollideBottom(top) || ball.didCollideTop(bottom)) {
			ball.setYSpeed(-ball.getYSpeed());
		}
		else if (ball.didCollideTop(leftPaddle) || ball.didCollideBottom(leftPaddle) || ball.didCollideTop(rightPaddle) || ball.didCollideBottom(rightPaddle)) {
			ball.setYSpeed(-ball.getYSpeed());
		}
		
		if (ball.didCollideLeft(left) || ball.didCollideRight(right)) {
			ball.setXSpeed(-ball.getXSpeed());
		}
		else if (ball.didCollideLeft(leftPaddle) || ball.didCollideRight(leftPaddle) || ball.didCollideLeft(rightPaddle) || ball.didCollideRight(rightPaddle)) {
			ball.setXSpeed(-ball.getXSpeed());
		}
		//paddle collisions
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