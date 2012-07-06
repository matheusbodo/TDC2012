package com.matheusbodo.tdc2012.screen;

import com.badlogic.gdx.Screen;

public interface ClickableScreen extends Screen {

	boolean touchDown(int x, int y);
	
	boolean touchUp(int x, int y);
	
	boolean touchDragged(int x, int y);
}
