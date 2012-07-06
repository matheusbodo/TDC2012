package com.matheusbodo.tdc2012.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.matheusbodo.tdc2012.BricksGame;
import com.matheusbodo.tdc2012.CollisionDetector;
import com.matheusbodo.tdc2012.GameAssets;

public class MenuScreen implements Screen, ClickableScreen {

	private static final String PLAY = "JOGAR";
	
	private BricksGame game;
	
	private OrthographicCamera camera;
	
	private SpriteBatch batch;
	
	private Vector3 touchPoint = new Vector3(0, 0, 0);
	
	private BitmapFont font;
	
	private Rectangle playButton;
	
	public MenuScreen(BricksGame game) {
		this.game = game;
		this.camera = new OrthographicCamera(480, 800);
		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
		this.batch = new SpriteBatch();
		this.font = game.getAssets().getFont();
		TextBounds textBounds = font.getBounds(PLAY);
		playButton = new Rectangle((int) (camera.viewportWidth - textBounds.width) / 2, 200, 
				(int) textBounds.width, (int) textBounds.height);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		camera.update();
		
		GameAssets assets = game.getAssets();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(assets.getBackgroundWaterRegion(), 0, 0, 480, 800);
		batch.draw(assets.getLogoRegion(), 112, 550, 256, 50);
		
		font.draw(batch, PLAY, playButton.x, playButton.y);
		
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

	@Override
	public boolean touchUp(int x, int y) {
		touchPoint.set(x, y, 0);
		camera.unproject(touchPoint);
		if (CollisionDetector.isPointInsideFontRectangle(touchPoint, playButton)) {
			game.setScreen(new GameScreen(game));
		}
		return true;
	}

	@Override
	public boolean touchDragged(int x, int y) {
		return false;
	}
	
	@Override
	public boolean touchDown(int x, int y) {
		return false;
	}

}
