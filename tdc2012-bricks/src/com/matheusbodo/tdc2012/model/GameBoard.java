package com.matheusbodo.tdc2012.model;

public class GameBoard {

	public static final float WIDTH = 4.8f;
	public static final float HEIGHT = 8.0f;
	
	private Platform platform;
	
	private Ball ball;
	
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

	public void update(float deltaTime) {
		ball.update(deltaTime, platform);
	}
}
