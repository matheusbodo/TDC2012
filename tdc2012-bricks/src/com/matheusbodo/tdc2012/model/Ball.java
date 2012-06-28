package com.matheusbodo.tdc2012.model;

import com.badlogic.gdx.math.Rectangle;

public class Ball {

	private static final float VERTICAL_SPEED = 2.5f;
	private static final float HORIZONTAL_SPEED = 1.6f;
	
	private Rectangle area = new Rectangle(0, 0, 0.1f, 0.1f);
	
	private VerticalDirection verticalDirection = VerticalDirection.UP;
	private HorizontalDirection horizontalDirection = HorizontalDirection.RIGHT;
	
	public void update(float deltaTime) {
		area.x = area.x + deltaTime * HORIZONTAL_SPEED * horizontalDirection.getMultiplier();
		area.y = area.y + deltaTime * VERTICAL_SPEED * verticalDirection.getMultiplier();
	}
	
	public void updateStartPosition(Platform platform) {
		Rectangle platformArea = platform.getArea();
		area.x = platformArea.x + (platformArea.width - area.width) / 2;
		area.y = platformArea.y + platformArea.height;
	}
	
	public void hitPlatform() {
		verticalDirection = VerticalDirection.UP;
	}
	
	public void hitLeftWall() {
		area.x -= area.x;
		horizontalDirection = HorizontalDirection.RIGHT;
	}
	
	public void hitRightWall() {
		area.x -= (area.x + area.width) - GameBoard.WIDTH;
		horizontalDirection = HorizontalDirection.LEFT;
	}
	
	public void hitDownWall() {
		area.y -= area.y;
		verticalDirection = VerticalDirection.UP;
	}
	
	public void hitTopWall() {
		area.y -= (area.y + area.height) - GameBoard.HEIGHT;
		verticalDirection = VerticalDirection.DOWN;
	}
	
	public Rectangle getArea() {
		return area;
	}
	
}
