package com.matheusbodo.tdc2012;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class CollisionDetector {

	public static boolean checkTopCollision(Rectangle objectArea, Rectangle collisionArea) {
		return (objectArea.x < collisionArea.x + collisionArea.width && 
				objectArea.x + objectArea.width > collisionArea.x && 
				objectArea.y < collisionArea.y + collisionArea.height && 
				objectArea.y + objectArea.height > collisionArea.y + collisionArea.height);
	}
	
	public static boolean checkBottomCollision(Rectangle objectArea, Rectangle collisionArea) {
		return (objectArea.x < collisionArea.x + collisionArea.width && 
				objectArea.x + objectArea.width > collisionArea.x && 
				objectArea.y < collisionArea.y && 
				objectArea.y + objectArea.height > collisionArea.y);
	}
	
	public static boolean checkLeftCollision(Rectangle objectArea, Rectangle collisionArea) {
		return (objectArea.x < collisionArea.x && 
				objectArea.x + objectArea.width > collisionArea.x && 
				objectArea.y < collisionArea.y + collisionArea.height && 
				objectArea.y + objectArea.height > collisionArea.y);
	}
	
	public static boolean checkRightCollision(Rectangle objectArea, Rectangle collisionArea) {
		return (objectArea.x < collisionArea.x + collisionArea.width && 
				objectArea.x + objectArea.width > collisionArea.x + collisionArea.width && 
				objectArea.y < collisionArea.y + collisionArea.height && 
				objectArea.y + objectArea.height > collisionArea.y);
	}
	
	public static boolean isPointInsideRectangle(Vector3 point, Rectangle rectangle) {
		return point.x >= rectangle.x && point.x <= rectangle.x + rectangle.width &&
		point.y >= rectangle.y && point.y <= rectangle.y + rectangle.height;
	}
	
	public static boolean isPointInsideFontRectangle(Vector3 point, Rectangle rectangle) {
		return point.x >= rectangle.x && point.x <= rectangle.x + rectangle.width &&
		point.y <= rectangle.y && point.y >= rectangle.y - rectangle.height;
	}
}
