package com.matheusbodo.tdc2012;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.matheusbodo.tdc2012.screen.ClickableScreen;
import com.matheusbodo.tdc2012.screen.MenuScreen;

public class BricksGame extends Game {

	private GameAssets assets;
	
	private BricksInputProcessor bricksInputProcessor;
	
	@Override
	public void create() {
		assets = new GameAssets();
		assets.load();
		bricksInputProcessor = new BricksInputProcessor();
		setScreen(new MenuScreen(this));
		Gdx.input.setInputProcessor(bricksInputProcessor);
		assets.getMusic().play();
	}
	
	@Override
	public void resume() {
		super.resume();
		assets.getMusic().play();
	}
	
	@Override
	public void pause() {
		super.pause();
		assets.getMusic().pause();
	}
	
	public void setScreen(ClickableScreen screen) {
		super.setScreen(screen);
		bricksInputProcessor.setClickableScreen(screen);
	}

	@Override
	public void dispose() {
		assets.dispose();
	}
	
	public GameAssets getAssets() {
		return assets;
	}

}
