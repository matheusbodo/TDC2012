package com.matheusbodo.tdc2012;

import com.badlogic.gdx.InputProcessor;
import com.matheusbodo.tdc2012.screen.ClickableScreen;

public class BricksInputProcessor implements InputProcessor {

	private ClickableScreen clickableScreen;
	
	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		return clickableScreen.touchUp(x, y);
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		return clickableScreen.touchDragged(x, y);
	}

	@Override
	public boolean touchMoved(int x, int y) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
	
	public void setClickableScreen(ClickableScreen clickableScreen) {
		this.clickableScreen = clickableScreen;
	}

}
