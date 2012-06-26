package com.matheusbodo.tdc2012.model;

import com.badlogic.gdx.math.Rectangle;

public class KickBar {

	private static final float WIDTH = 1.5f;
	
	private Rectangle area = new Rectangle((GameBoard.WIDTH - WIDTH) / 2, 1.0f, WIDTH, 0.4f);

	public Rectangle getArea() {
		return area;
	}
	
	public void setPosition(float x, float y) {
		if (x < 0) {
			x = 0;
		} else if (x + area.width > GameBoard.WIDTH) {
			x = GameBoard.WIDTH - area.width;
		}
		this.area.x = x;
		this.area.y = y;
	}
	
}
