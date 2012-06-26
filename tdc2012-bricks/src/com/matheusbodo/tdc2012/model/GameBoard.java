package com.matheusbodo.tdc2012.model;

public class GameBoard {

	public static final float WIDTH = 4.8f;
	public static final float HEIGHT = 8.0f;
	
	private KickBar kickBar;
	
	private Ball ball;
	
	public void createGame() {
		kickBar = new KickBar();
		ball = new Ball();
		ball.updateStartPosition(kickBar);
	}
	
	public KickBar getKickBar() {
		return kickBar;
	}
	
	public Ball getBall() {
		return ball;
	}

	public void update(float deltaTime) {
		ball.update(deltaTime, kickBar);
	}
}
