package com.matheusbodo.tdc2012.model;

import com.badlogic.gdx.math.Rectangle;
import com.matheusbodo.tdc2012.CollisionDetector;

public class Ball {

	private static final float VERTICAL_SPEED = 2.5f;
	private static final float HORIZONTAL_SPEED = 1.6f;
	
	private Rectangle area = new Rectangle(0, 0, 0.1f, 0.1f);
	
	private VerticalDirection verticalDirection = VerticalDirection.UP;
	private HorizontalDirection horizontalDirection = HorizontalDirection.RIGHT;
	
	public void update(float deltaTime, KickBar kickBar) {
		
		area.x = area.x + deltaTime * HORIZONTAL_SPEED * horizontalDirection.getMultiplier();
		area.y = area.y + deltaTime * VERTICAL_SPEED * verticalDirection.getMultiplier();
		
		if (CollisionDetector.checkTopCollision(area, kickBar.getArea())) {
			verticalDirection = VerticalDirection.UP;
			return;
		}
		
		if (area.x < 0) {
			area.x -= area.x;
			horizontalDirection = HorizontalDirection.RIGHT;
		} else if (area.x + area.width > GameBoard.WIDTH) {
			area.x -= (area.x + area.width) - GameBoard.WIDTH;
			horizontalDirection = HorizontalDirection.LEFT;
		}
		
		if (area.y  < 0) {
			area.y -= area.y;
			verticalDirection = VerticalDirection.UP;
		} else if (area.y + area.height > GameBoard.HEIGHT) {
			area.y -= (area.y + area.height) - GameBoard.HEIGHT;
			verticalDirection = VerticalDirection.DOWN;
		}
	}
	
	public void updateStartPosition(KickBar kickBar) {
		Rectangle kickBarArea = kickBar.getArea();
		area.x = kickBarArea.x + (kickBarArea.width - area.width) / 2;
		area.y = kickBarArea.y + kickBarArea.height;
	}
	
	public Rectangle getArea() {
		return area;
	}
	
}
