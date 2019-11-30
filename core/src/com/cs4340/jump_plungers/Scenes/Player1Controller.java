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

public class Player1Controller {
    public static Stage stage;
    public Viewport viewport3;

    Label p1jumpLabel;
    Label p1lungeLabel;

    public Player1Controller(SpriteBatch sb){

        viewport3 = new FitViewport(JumpPlungers.vWidth,JumpPlungers.vHeight,new OrthographicCamera());
        //viewport.apply();
        stage = new Stage(viewport3,sb);
        System.out.println(stage.toString());
        Table table = new Table();
        table.bottom();
        table.setFillParent(false);

        p1jumpLabel = new Label("Jump", new  Label.LabelStyle(new BitmapFont(), Color.WHITE));
        p1lungeLabel = new Label("Lunge", new  Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(p1jumpLabel).padBottom(15).padLeft(100);
        table.add(p1lungeLabel).padBottom(15).padLeft(30);

        stage.addActor(table);

    }

}
