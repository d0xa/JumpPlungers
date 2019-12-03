package com.cs4340.jump_plungers.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.cs4340.jump_plungers.JumpPlungers;

public class Hud implements Disposable {
    public Stage stage;
    public Viewport viewport2;
    //private OrthographicCamera gameCam;
    private Integer roundTimer;
    //private float timeCount;
    private Integer score1;
    private Integer score2;

    Label player1Label;
    Label versusLabel;
    Label player2Label;
    Label countdownLabel;
    Label player1ScoreLabel;
    Label player2ScoreLabel;
    Label p1jumpLabel;
    Label p1lungeLabel;

    public Hud(SpriteBatch sb){
        roundTimer = 99;
        score1 =0;
        score2 =0;

        viewport2 = new FitViewport(JumpPlungers.vWidth,JumpPlungers.vHeight,new OrthographicCamera());
        //viewport.apply();
        stage = new Stage(viewport2,sb);
        System.out.println(stage.toString());
        Table table = new Table();
        table.top();
        table.setFillParent(true);

        countdownLabel = new Label(String.format("%02d",roundTimer), new  Label.LabelStyle(new BitmapFont(),     Color.WHITE));
        player1ScoreLabel = new Label(String.format("%03d",score1), new  Label.LabelStyle(new BitmapFont(), Color.GREEN));
        player2ScoreLabel = new Label(String.format("%03d",score2), new  Label.LabelStyle(new BitmapFont(), Color.GREEN));
        player1Label = new Label("player1", new  Label.LabelStyle(new BitmapFont(), Color.WHITE));
        versusLabel = new Label("VS", new  Label.LabelStyle(new BitmapFont(), Color.RED));
        player2Label = new Label("player2", new  Label.LabelStyle(new BitmapFont(), Color.WHITE));
        //p1jumpLabel = new Label("Jump", new  Label.LabelStyle(new BitmapFont(), Color.WHITE));
        //p1lungeLabel = new Label("Lunge", new  Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(player1Label).expandX().padTop(10);
        table.add(versusLabel).expandX().padTop(10);
        table.add(player2Label).expandX().padTop(10);
        table.row();
        table.add(player1ScoreLabel).expandX();
        table.add(countdownLabel).expandX();
        table.add(player2ScoreLabel).expandX();
        table.row();
        //table.add(p1jumpLabel).left().bottom();
        //table.add(p1lungeLabel).left().bottom();

        stage.addActor(table);

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
