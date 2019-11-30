package com.cs4340.jump_plungers.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.cs4340.jump_plungers.JumpPlungers;

public class Player2Controller {
    public static Stage stage;
    public Viewport viewport4;

    Label p2jumpLabel;
    Label p2lungeLabel;

    public Player2Controller(SpriteBatch sb){

        viewport4 = new FitViewport(JumpPlungers.vWidth,JumpPlungers.vHeight,new OrthographicCamera());
        //viewport.apply();
        stage = new Stage(viewport4,sb);
        System.out.println(stage.toString());
        Table table = new Table();
        table.bottom();
        table.setFillParent(false);

        p2jumpLabel = new Label("Jump", new  Label.LabelStyle(new BitmapFont(), Color.WHITE));
        p2lungeLabel = new Label("Lunge", new  Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(p2jumpLabel).padBottom(15).padLeft(700);
        table.add(p2lungeLabel).padBottom(15).padLeft(20);

        stage.addActor(table);

    }

}
