package com.cs4340.jump_plungers.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.cs4340.jump_plungers.JumpPlungers;

public class HUD {
    public Stage stage;
    private Viewport viewport;

    private Integer roundTimer;
    //private float timeCount;
    private Integer score;
    Label player1Label;
    Label versusLabel;
    Label player2Label;
    Label countdownLabel;
    Label player1ScoreLabel;
    Label player2ScoreLabel;

    public HUD(SpriteBatch sb){
        roundTimer = 0;
        score =0;
        viewport = new FitViewport(JumpPlungers.vWidth,JumpPlungers.vHeight,new OrthographicCamera());
        stage = new Stage(viewport,sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        countdownLabel = new Label(String.format("%03d",roundTimer), new  Label.LabelStyle(new BitmapFont(),     Color.WHITE));
        player1ScoreLabel = new Label(String.format("%03d",roundTimer), new  Label.LabelStyle(new BitmapFont(), Color.GREEN));
        player2ScoreLabel = new Label(String.format("%03d",roundTimer), new  Label.LabelStyle(new BitmapFont(), Color.GREEN));
        player1Label = new Label("player1", new  Label.LabelStyle(new BitmapFont(), Color.WHITE));
        versusLabel = new Label("VS", new  Label.LabelStyle(new BitmapFont(), Color.RED));
        player2Label = new Label("player2", new  Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(player1Label).expandX().padTop(10);
        table.add(versusLabel).expandX().padTop(10);
        table.add(player2Label).expandX().padTop(10);
        table.row();
        table.add(player1ScoreLabel).expandX();
        table.add(countdownLabel).expandX();
        table.add(player2ScoreLabel).expandX();
        stage.addActor(table);
    }
}
