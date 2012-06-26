package com.matheusbodo.tdc2012;

import com.badlogic.gdx.math.Rectangle;

public class CollisionDetector {

	public static boolean checkTopCollision(Rectangle objectArea, Rectangle collisionArea) {
		return (objectArea.x < collisionArea.x + collisionArea.width && objectArea.x + objectArea.width > collisionArea.x && objectArea.y < collisionArea.y + collisionArea.height && objectArea.y + objectArea.height > collisionArea.y);
	}
}
