package com.matheusbodo.tdc2012.model;

import com.badlogic.gdx.math.Rectangle;
import com.matheusbodo.tdc2012.CollisionDetector;

public class Ball {

	private static final float VERTICAL_SPEED = 3.5f;
	private static final float HORIZONTAL_SPEED = 2.0f;
	
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
	
	public void hitObjectDown() {
		verticalDirection = VerticalDirection.UP;
	}
	
	public void hitObjectUp() {
		verticalDirection = VerticalDirection.DOWN;
	}
	
	public void hitObjectRight() {
		horizontalDirection = HorizontalDirection.LEFT;
	}
	
	public void hitObjectLeft() {
		horizontalDirection = HorizontalDirection.RIGHT;
	}
	
	public void hitLeftWall() {
		area.x -= area.x;
		hitObjectLeft();
	}
	
	public void hitRightWall() {
		area.x -= (area.x + area.width) - GameBoard.WIDTH;
		hitObjectRight();
	}
	
	public void hitTopWall() {
		area.y -= (area.y + area.height) - GameBoard.HEIGHT;
		hitObjectUp();
	}
	
	public Rectangle getArea() {
		return area;
	}

	public boolean checkTopCollision(Rectangle collisionArea) {
		return VerticalDirection.DOWN.equals(verticalDirection) && 
				CollisionDetector.checkTopCollision(area, collisionArea);
	}
	
	public boolean checkBottomCollision(Rectangle collisionArea) {
		return VerticalDirection.UP.equals(verticalDirection) && 
				CollisionDetector.checkBottomCollision(area, collisionArea);
	}

	public boolean checkLeftCollision(Rectangle collisionArea) {
		return HorizontalDirection.RIGHT.equals(horizontalDirection) && 
		CollisionDetector.checkLeftCollision(area, collisionArea);
	}
	
	public boolean checkRightCollision(Rectangle collisionArea) {
		return HorizontalDirection.LEFT.equals(horizontalDirection) && 
		CollisionDetector.checkRightCollision(area, collisionArea);
	}
	
}
