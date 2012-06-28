package com.matheusbodo.tdc2012;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameAssets {

	private Texture texture;
	
	private TextureRegion backgroundWaterRegion;
	private TextureRegion logoRegion;
	private TextureRegion platformRegion;
	private TextureRegion ballRegion;
	private TextureRegion brickRegion;
	
	private Music music;
	private Sound beep;
	
	public void load() {
		texture = new Texture(Gdx.files.internal("data/textures.png"));
		backgroundWaterRegion = new TextureRegion(texture, 0, 0, 256, 256);
		logoRegion = new TextureRegion(texture, 256, 462, 256, 50);
		platformRegion = new TextureRegion(texture, 259, 296, 80, 20);
		ballRegion = new TextureRegion(texture, 256, 286, 10, 10);
		brickRegion = new TextureRegion(texture, 256, 256, 50, 30);
		
		music = Gdx.audio.newMusic(Gdx.files.internal("data/music.ogg"));
		music.setLooping(true);
		music.setVolume(0.5f);
		
		beep = Gdx.audio.newSound(Gdx.files.internal("data/beep.ogg"));
	}
	
	public void dispose() {
		texture.dispose();
	}
	
	public Texture getTexture() {
		return texture;
	}
	
	public TextureRegion getBackgroundWaterRegion() {
		return backgroundWaterRegion;
	}
	
	public TextureRegion getLogoRegion() {
		return logoRegion;
	}
	
	public TextureRegion getPlatformRegion() {
		return platformRegion;
	}
	
	public TextureRegion getBallRegion() {
		return ballRegion;
	}
	
	public TextureRegion getBrickRegion() {
		return brickRegion;
	}
	
	public Music getMusic() {
		return music;
	}
	
	public Sound getBeep() {
		return beep;
	}
}
