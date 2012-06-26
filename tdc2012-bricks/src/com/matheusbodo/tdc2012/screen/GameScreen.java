package com.matheusbodo.tdc2012.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.matheusbodo.tdc2012.BricksGame;
import com.matheusbodo.tdc2012.BricksInputProcessor;
import com.matheusbodo.tdc2012.GameAssets;
import com.matheusbodo.tdc2012.model.Ball;
import com.matheusbodo.tdc2012.model.GameBoard;
import com.matheusbodo.tdc2012.model.KickBar;

public class GameScreen implements Screen {

	private BricksGame game;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	
	private GameBoard gameBoard;
	private Vector3 touchPoint = new Vector3(0, 0, 0);
	
	public GameScreen(BricksGame game) {
		this.game = game;
		this.camera = new OrthographicCamera(4.8f, 8);
		this.camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
		this.batch = new SpriteBatch();
		this.gameBoard = new GameBoard();
		this.gameBoard.createGame();
		InputProcessor gameInputProcessor = new BricksInputProcessor(this);
		Gdx.input.setInputProcessor(gameInputProcessor);
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
		
		KickBar kickBar = gameBoard.getKickBar();
		Rectangle kickBarArea = kickBar.getArea();
		batch.draw(assets.getKickBarRegion(), kickBarArea.x, kickBarArea.y, kickBarArea.width, kickBarArea.height);
		
		Ball ball = gameBoard.getBall();
		Rectangle ballArea = ball.getArea();
		batch.draw(assets.getBallRegion(), ballArea.x, ballArea.y, ballArea.width, ballArea.height);
		batch.end();
	}

	@Override
	public void resize(int width, int height) { }

	@Override
	public void show() { }

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
		KickBar kickBar = gameBoard.getKickBar();
		Rectangle kickBarArea = kickBar.getArea();
		kickBar.setPosition(touchPoint.x - kickBarArea.width / 2, kickBarArea.y);
		return true;
	}
}
