package com.matheusbodo.tdc2012;

import com.badlogic.gdx.Game;
import com.matheusbodo.tdc2012.screen.MenuScreen;

public class BricksGame extends Game {

	private GameAssets assets;
	
	@Override
	public void create() {
		assets = new GameAssets();
		assets.load();
		setScreen(new MenuScreen(this));
	}

	@Override
	public void dispose() {
		assets.dispose();
	}
	
	public GameAssets getAssets() {
		return assets;
	}

}
