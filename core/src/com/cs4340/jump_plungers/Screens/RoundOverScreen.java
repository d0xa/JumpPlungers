package com.cs4340.jump_plungers.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.cs4340.jump_plungers.JumpPlungers;
import com.cs4340.jump_plungers.Scenes.Hud;
import com.cs4340.jump_plungers.Sprites.Player1;

public class RoundOverScreen implements Screen {
    private Viewport viewport;
    private Stage stage;
    private float elapsedTime;
    private Game game;
    private Player1 player1;
    private Hud hud;
    //private Player2;

    public RoundOverScreen(Game game, Player1 player1,Hud hud){
        this.game = game;
        this.player1 = player1;
        this.hud = hud;
        viewport = new FillViewport(JumpPlungers.vWidth,JumpPlungers.vHeight,new OrthographicCamera());
        stage = new Stage(viewport,((JumpPlungers)game).batch);
        Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.RED);

        Table table = new Table();
        table.center();
        table.setFillParent(true);
        Label timeUpLabel = new Label("TIMES UP!",font);
        table.add(timeUpLabel).expandX();

        stage.addActor(table);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        elapsedTime += delta;
        if(elapsedTime >3.0 && !player1.isMatchOver()){
            game.setScreen(new PlayScreen((JumpPlungers) game));
            hud.timeOut();
        }
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {

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
