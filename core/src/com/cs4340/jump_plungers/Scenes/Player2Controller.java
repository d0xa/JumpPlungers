package com.cs4340.jump_plungers.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.cs4340.jump_plungers.JumpPlungers;

public class Player2Controller {
    public static Stage stage;
    public Viewport viewport3;

    Label p2jumpLabel;
    Label p2lungeLabel;
    boolean jumpPressed, lungePressed = false;



    public Player2Controller(SpriteBatch sb){

        viewport3 = new FitViewport(JumpPlungers.vWidth,JumpPlungers.vHeight,new OrthographicCamera());
        //viewport.apply();
        stage = new Stage(viewport3,sb);
        System.out.println(stage.toString());
        Table table = new Table();
        table.bottom();
        table.setFillParent(false);

        p2jumpLabel = new Label("Jump", new  Label.LabelStyle(new BitmapFont(), Color.WHITE));
        p2lungeLabel = new Label("Lunge", new  Label.LabelStyle(new BitmapFont(), Color.WHITE));

        p2jumpLabel.setTouchable(Touchable.enabled);
        p2lungeLabel.setTouchable(Touchable.enabled);
        p2jumpLabel.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                jumpPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                jumpPressed = false;
            }
        });
        p2lungeLabel.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                lungePressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                lungePressed = false;
            }
        });
        table.add(p2jumpLabel).padBottom(15).padLeft(700);
        table.add(p2lungeLabel).padBottom(15).padLeft(20);

        stage.addActor(table);

    }
    public void draw(){
        stage.draw();
    }

    public boolean isJumpPressed() {
        return jumpPressed;
    }

    public boolean isLungePressed() {
        return lungePressed;
    }
    public void resize(int width,int height){
        viewport3.update(width, height);
    }
}
