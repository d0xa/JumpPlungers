package com.cs4340.jump_plungers.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.cs4340.jump_plungers.JumpPlungers;
import com.cs4340.jump_plungers.Scenes.HUD;

public class PlayScreen implements Screen {
    private JumpPlungers game;
    //Texture texture;
    private OrthographicCamera gameCam;
    private Viewport gamePort;
    public HUD hud;
    public PlayScreen(JumpPlungers game){
        this.game = game;
        //texture = new Texture("badlogic.jpg");
        gameCam = new OrthographicCamera();
        gamePort = new FitViewport(JumpPlungers.vWidth,JumpPlungers.vHeight,gameCam); //screen size with camera
        hud = new HUD(game.batch);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
