package com.matheusbodo.tdc2012.model;

public enum VerticalDirection {
	
	UP(1),
	DOWN(-1);
	
	private int directionMultiplier;
	
	private VerticalDirection(int directionMultiplier) {
		this.directionMultiplier = directionMultiplier;
	}
	
	public int getMultiplier() {
		return directionMultiplier;
	}

}
