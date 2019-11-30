package com.cs4340.jump_plungers;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cs4340.jump_plungers.Screens.PlayScreen;

public class JumpPlungers extends Game {
	public SpriteBatch batch; // so all screens have acess
	public static final int vWidth =400;
	public static final int vHeight=208;
	public static AssetManager manager;
	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		manager = new AssetManager();
		manager.load("Audio/fightone_160bpm.mp3", Music.class);
		manager.finishLoading();
		setScreen(new PlayScreen(this));
	}

	@Override
	public void render () {

		super.render(); //delagates the render method to another screen
		manager.update();
	}
	
//	@Override
//	public void dispose () {
//		batch.dispose();
//		img.dispose();
//	}
}
