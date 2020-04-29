package Unit15;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;

public class BreakOut extends Canvas implements KeyListener, Runnable {
	private Ball ball;
	private Paddle paddle;
	private boolean[] keys; // keeps track of what keys are pressed
	
	private List<Block> breakoutBlocks;
	
	private Wall top, bottom, left, right;
	
	private final int boardWidth = 800;
	private final int boardHeight = 600;
	
	private List<Integer> toRemove;

	private int score;
	private final int numHorizontal = 6;
	private final int numVertical = 5;
	private BufferedImage back;
	
	public BreakOut() {
		toRemove = new ArrayList<Integer>();
		ball = new Ball();
		paddle = new Paddle(boardWidth /2, 550, 70, 20, Color.BLACK, 5);

		top = new Wall(0, 0, 820, true);
		bottom = new Wall(0, 610, 800 + 20, true);
		left = new Wall(0, 10, 600, false);
		right = new Wall(810, 10, 600, false);
		breakoutBlocks = new ArrayList<Block>();
		
		keys = new boolean[2];
		reset();

		setBackground(Color.WHITE);
		setVisible(true);
		this.addKeyListener(this);
		new Thread(this).start();
	}
	
	public void reset() {
		ball.setPos(boardWidth / 2, boardHeight /2);
		ball.setXSpeed(2);
		ball.setYSpeed(1);
		breakoutBlocks.clear();
		for (int i = 0; i < numVertical; i++) {
			for (int j = 0; j < numHorizontal; j++) {
				breakoutBlocks.add(new Block(30 + j * boardWidth / numHorizontal, 14 + 30*i, 100, 25));
			}
		}
		score = 0;
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		Graphics2D twoDGraph = (Graphics2D) window;
		back = (BufferedImage) (createImage(getWidth(), getHeight()));
		Graphics graphToBack = back.createGraphics();
		for (Block b : breakoutBlocks){
			b.draw(graphToBack);
		}
		ball.moveAndDraw(graphToBack);
		paddle.draw(graphToBack);
		top.draw(graphToBack);
		bottom.draw(graphToBack);
		left.draw(graphToBack);
		right.draw(graphToBack);
		toRemove.clear();
		for (int i = 0; i < breakoutBlocks.size(); i++){
			Block b = breakoutBlocks.get(i);
			boolean done = false;
			if (ball.didCollideLeft(b) || ball.didCollideRight(b)){
				ball.setXSpeed(-ball.getXSpeed());
				done = true;
			}
			if (ball.didCollideBottom(b) || ball.didCollideTop(b)){
				ball.setYSpeed(-ball.getYSpeed());
				done = true;
			}
			if (done){
				toRemove.add(i);
				score++;
			}
		}
		for (int r : toRemove){
			Block b = breakoutBlocks.get(r);
			b.remove(window);
			breakoutBlocks.remove(b);
		}
		if (ball.didCollideTop(bottom)) {
			ball.draw(window, Color.WHITE);
			reset();
		}
		else if (ball.didCollideBottom(top)){
			ball.setYSpeed(-ball.getYSpeed());
		} 
		else if (ball.didCollideTop(paddle) || ball.didCollideBottom(paddle)){
			ball.setYSpeed(-ball.getYSpeed());
		}
		if (ball.didCollideLeft(left)){
			ball.setXSpeed(-ball.getXSpeed());
		}
		if (ball.didCollideRight(right)){
			ball.setXSpeed(-ball.getXSpeed());
		} 
		else if (ball.didCollideLeft(paddle) || ball.didCollideRight(paddle)){
			ball.setXSpeed(-ball.getXSpeed());
		}
		
		if (keys[0] == true && paddle.getX() > 10){
			paddle.moveLeftAndDraw(graphToBack);
		}
		if (keys[1] == true && paddle.getX() < 750){
			paddle.moveRightAndDraw(graphToBack);
		}
		
		twoDGraph.drawImage(back, null, 0, 0);
		twoDGraph.drawString("Score: " + score , boardWidth / 2, boardHeight - 10);
	}

	public void keyPressed(KeyEvent e) {
		switch (toUpperCase(e.getKeyChar())) {
		case 'A':
			keys[0] = true;
			break;
		case 'D':
			keys[1] = true;
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (toUpperCase(e.getKeyChar())) {
		case 'A':
			keys[0] = false;
			break;
		case 'D':
			keys[1] = false;
			break;
		}
	}

	public void keyTyped(KeyEvent e) {
		// no code needed here
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
