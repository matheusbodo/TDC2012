package com.matheusbodo.tdc2012.model;

import com.badlogic.gdx.math.Rectangle;
import com.matheusbodo.tdc2012.CollisionDetector;

public class GameBoard {

	public static final float WIDTH = 4.8f;
	public static final float HEIGHT = 8.0f;
	
	private Platform platform;
	private Ball ball;
	
	private boolean running = false;
	
	public void createGame() {
		platform = new Platform();
		ball = new Ball();
		ball.updateStartPosition(platform);
	}
	
	public Platform getPlatform() {
		return platform;
	}
	
	public Ball getBall() {
		return ball;
	}
	
	public void dragPlatform(float x, float y) {
			Rectangle platformArea = platform.getArea();
			platform.setPosition(x - platformArea.width / 2, platformArea.y);
			if (!running) {
				ball.updateStartPosition(platform);
			}
	}
	
	public void start() {
		if (!running) {
			running = true;
		}
	}

	public void update(float deltaTime) {
		if (running) {
			ball.update(deltaTime);
			Rectangle ballArea = ball.getArea();
			if (CollisionDetector.checkTopCollision(ballArea, platform.getArea())) {
				ball.hitPlatform();
			}
			
			if (ballArea.x < 0) {
				ball.hitLeftWall();
			} else if (ballArea.x + ballArea.width > GameBoard.WIDTH) {
				ball.hitRightWall();
			}
			
			if (ballArea.y  < 0) {
				ball.hitDownWall(); // TODO game over
			} else if (ballArea.y + ballArea.height > GameBoard.HEIGHT) {
				ball.hitTopWall();
			}
		}
	}
}
