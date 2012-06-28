package com.matheusbodo.tdc2012.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.matheusbodo.tdc2012.BricksGame;
import com.matheusbodo.tdc2012.GameAssets;
import com.matheusbodo.tdc2012.model.Ball;
import com.matheusbodo.tdc2012.model.GameBoard;
import com.matheusbodo.tdc2012.model.Platform;

public class GameScreen implements ClickableScreen {

	private BricksGame game;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	
	private GameBoard gameBoard;
	private Vector3 touchPoint = new Vector3(0, 0, 0);
	
	public GameScreen(BricksGame game) {
		this.game = game;
	}

	@Override
	public void render(float deltaTime) {
		gameBoard.update(deltaTime);
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		camera.update();
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		GameAssets assets = game.getAssets();
		batch.draw(assets.getBackgroundWaterRegion(), 0, 0, 4.8f, 8);
		
		Platform platform = gameBoard.getPlatform();
		Rectangle platformArea = platform.getArea();
		batch.draw(assets.getPlatformRegion(), platformArea.x, platformArea.y, platformArea.width, platformArea.height);
		
		Ball ball = gameBoard.getBall();
		Rectangle ballArea = ball.getArea();
		batch.draw(assets.getBallRegion(), ballArea.x, ballArea.y, ballArea.width, ballArea.height);
		batch.end();
	}

	@Override
	public void resize(int width, int height) { }

	@Override
	public void show() {
		this.camera = new OrthographicCamera(4.8f, 8);
		this.camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
		this.batch = new SpriteBatch();
		this.gameBoard = new GameBoard();
		this.gameBoard.createGame();
	}

	@Override
	public void hide() { }

	@Override
	public void pause() { }

	@Override
	public void resume() { }

	@Override
	public void dispose() {
		batch.dispose();
	}
	
	public boolean touchDragged(int x, int y) {
		touchPoint.set(x, y, 0);
		camera.unproject(touchPoint);
		gameBoard.dragPlatform(touchPoint.x, touchPoint.y);
		return true;
	}
	
	public boolean touchUp(int x, int y) {
		gameBoard.start();
		return true;
	}
}
