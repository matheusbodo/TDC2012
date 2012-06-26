package com.matheusbodo.tdc2012.model;

public enum HorizontalDirection {

	LEFT(-1),
	RIGHT(1);
	
	private int directionMultiplier;
	
	private HorizontalDirection(int directionMultiplier) {
		this.directionMultiplier = directionMultiplier;
	}
	
	public int getMultiplier() {
		return directionMultiplier;
	}
}
