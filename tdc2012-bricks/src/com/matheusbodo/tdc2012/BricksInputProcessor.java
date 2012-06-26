package com.matheusbodo.tdc2012;

import com.badlogic.gdx.InputProcessor;
import com.matheusbodo.tdc2012.screen.GameScreen;

public class BricksInputProcessor implements InputProcessor {

	private GameScreen gameScreen;
	
	public BricksInputProcessor(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
	}
	
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
		return false;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		return gameScreen.touchDragged(x, y);
	}

	@Override
	public boolean touchMoved(int x, int y) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
