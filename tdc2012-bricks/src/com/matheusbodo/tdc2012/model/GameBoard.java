package com.matheusbodo.tdc2012.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.math.Rectangle;
import com.matheusbodo.tdc2012.CollisionDetector;
import com.matheusbodo.tdc2012.GameAssets;

public class GameBoard {

	private static final int COLUMNS = 8;
	private static final int ROWS = 5;
	
	public static final float WIDTH = 4.8f;
	public static final float HEIGHT = 8.0f;
	
	private Platform platform;
	private Ball ball;
	private List<Brick> brickList = new ArrayList<Brick>();
	
	private boolean running = false;
	
	public GameAssets assets;
	
	public GameBoard(GameAssets assets) {
		this.assets = assets;
	}
	
	public void createGame() {
		platform = new Platform();
		createBricks();
		ball = new Ball();
		ball.updateStartPosition(platform);
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
			checkPlatformCollision(ballArea);
			checkBricksCollision();
			checkWallsCollision(ballArea);
		}
	}

	public void checkPlatformCollision(Rectangle ballArea) {
		if (CollisionDetector.checkTopCollision(ballArea, platform.getArea())) {
			ball.hitObjectDown();
			assets.getBeep().play(1.0f);
		}
	}
	
	private void checkBricksCollision() {
		Iterator<Brick> it = brickList.iterator();
		while (it.hasNext()) {
			Brick brick = it.next();
			if (ball.checkTopCollision(brick.getArea())) {
				ball.hitObjectDown();
				assets.getBeep().play(1.0f);
				it.remove();
				break;
			} else if (ball.checkBottomCollision(brick.getArea())) {
				ball.hitObjectUp();
				assets.getBeep().play(1.0f);
				it.remove();
				break;
			} else if (ball.checkLeftCollision(brick.getArea())) {
				ball.hitObjectRight();
				assets.getBeep().play(1.0f);
				it.remove();
				break;
			} else if (ball.checkRightCollision(brick.getArea())) {
				ball.hitObjectLeft();
				assets.getBeep().play(1.0f);
				it.remove();
				break;
			}
		}
		
		if (brickList.isEmpty()) {
			stop();
			createBricks();
		}
	}
	
	public void checkWallsCollision(Rectangle ballArea) {
		if (ballArea.x < 0) {
			ball.hitLeftWall();
		} else if (ballArea.x + ballArea.width > GameBoard.WIDTH) {
			ball.hitRightWall();
		}
		
		if (ballArea.y  < 0) {
			stop();
		} else if (ballArea.y + ballArea.height > GameBoard.HEIGHT) {
			ball.hitTopWall();
		}
	}

	public void stop() {
		running = false;
		ball.updateStartPosition(platform);
	}
	
	private void createBricks() {
		float bottom = HEIGHT - 3 * Brick.HEIGHT;
		for (int i = 0; i < ROWS; i++) {
			float left = (WIDTH - COLUMNS * Brick.WIDTH) / 2;
			for (int j = 0; j < COLUMNS; j++) {
				Brick brick = new Brick(left, bottom);
				brickList.add(brick);
				left += Brick.WIDTH;
			}
			bottom -= Brick.HEIGHT;
		}
	}
	
	public Platform getPlatform() {
		return platform;
	}
	
	public Ball getBall() {
		return ball;
	}
	
	public List<Brick> getBrickList() {
		return brickList;
	}
	
}
