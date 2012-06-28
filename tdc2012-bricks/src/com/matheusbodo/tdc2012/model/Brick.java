package com.matheusbodo.tdc2012.model;

import com.badlogic.gdx.math.Rectangle;

public class Brick {

	public static final float WIDTH = 0.5f;
	public static final float HEIGHT = 0.3f;
	
	private Rectangle area = new Rectangle(0, 0, WIDTH, HEIGHT);
	
	public Brick(float x, float y) {
		area.x = x;
		area.y = y;
	}
	
	public Rectangle getArea() {
		return area;
	}
}
