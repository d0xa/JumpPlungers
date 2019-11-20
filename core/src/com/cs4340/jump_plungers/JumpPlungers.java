package com.cs4340.jump_plungers;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cs4340.jump_plungers.Screens.PlayScreen;

public class JumpPlungers extends Game {
	public SpriteBatch batch; // so all screens have acess
	public static final int vWidth =400;
	public static final int vHeight=208;

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new PlayScreen(this));
		//img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		super.render(); //delagates the render method to another screen
	}
	
//	@Override
//	public void dispose () {
//		batch.dispose();
//		img.dispose();
//	}
}
