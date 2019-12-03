package com.cs4340.jump_plungers.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.cs4340.jump_plungers.JumpPlungers;
import com.cs4340.jump_plungers.Screens.PlayScreen;

public class Player1 extends Sprite {
    public World world;
    public Body body;
    public static Sprite sprite;
    private TextureRegion player1Idle;
    private Texture idle;
    private Texture jump;
    private Texture lunge;



    public Player1(World world, PlayScreen screen){
        super(screen.getAtlas().findRegion("idle"));
        //idle =super(screen.getAtlas().createSprite("player1.png"));
        this.world=world;
        definePlayer1();
        //sprite = new Sprite();
//        idle = (Texture)
        player1Idle = new TextureRegion(screen.getAtlas().findRegion("idle"));
        sprite = new Sprite(player1Idle);
        setPosition(1,1);
        setBounds(0,0,32,32);
        setRegion(sprite);
    }
    public void update(float dt){
        setPosition(body.getPosition().x, body.getPosition().y );
    }
    private void definePlayer1() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(1,1);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bodyDef);
        FixtureDef fixtureDef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(16);
        fixtureDef.shape=shape;
        body.createFixture(fixtureDef);
    }
    public Texture getIdle() {
        return idle;
    }

    public Texture getJump() {
        return jump;
    }

    public Texture getLunge() {
        return lunge;
    }
}
