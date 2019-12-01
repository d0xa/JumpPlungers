package com.cs4340.jump_plungers.Sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.cs4340.jump_plungers.JumpPlungers;

public class Player1 extends Sprite {
    public World world;
    public Body body;

    public Player1(World world){
        this.world=world;
        definePlayer1();
    }

    private void definePlayer1() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(32/ JumpPlungers.PPM,32/JumpPlungers.PPM);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bodyDef);

        FixtureDef fixtureDef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5/JumpPlungers.PPM);

        fixtureDef.shape=shape;
        body.createFixture(fixtureDef);
    }
}
