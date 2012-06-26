package com.matheusbodo.tdc2012.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.matheusbodo.tdc2012.BricksGame;
import com.matheusbodo.tdc2012.GameAssets;

public class MenuScreen implements Screen {

	private BricksGame game;
	
	private OrthographicCamera camera;
	
	private SpriteBatch batch;
	
	public MenuScreen(BricksGame game) {
		this.game = game;
		this.camera = new OrthographicCamera(480, 800);
		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
		this.batch = new SpriteBatch();
	}
	
	@Override
	public void render(float delta) {
		if (Gdx.input.justTouched()) {
			game.setScreen(new GameScreen(game));
		}
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		camera.update();
		
		GameAssets assets = game.getAssets();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(assets.getBackgroundWaterRegion(), 0, 0, 480, 800);
		batch.draw(assets.getLogoRegion(), 112, 550, 256, 50);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

}
