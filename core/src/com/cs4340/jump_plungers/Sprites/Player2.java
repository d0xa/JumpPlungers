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
import com.badlogic.gdx.utils.Array;
import com.cs4340.jump_plungers.JumpPlungers;
import com.cs4340.jump_plungers.Screens.PlayScreen;

public class Player2 extends Sprite {
    public enum State {Idle, Jumping, Lunge};
    public State currentState;
    public State previopusState;
    public World world;
    public Body body;
    public static Sprite sprite;
    private TextureRegion player1Idle;
    private TextureRegion player1Jump;
    private TextureRegion player1Plunge;
    public boolean facingRight;
    private float StateTimer;
    private int roundsWon;
    private boolean matchOver = false;
    private boolean gotHit = false;

    public boolean getGotHit() {
        return gotHit;
    }

    public void setGotHit(boolean gotHit) {
        this.gotHit = gotHit;
    }
//    private Texture idle;
//    private Texture jump;
//    private Texture lunge;


    public Player2(World world, PlayScreen screen) {
        super(screen.getAtlas().findRegion("idle"));
        //idle =super(screen.getAtlas().createSprite("player1.png"));
        this.world = world;
        currentState = State.Idle;
        previopusState = State.Idle;
        player1Idle = new TextureRegion(screen.getAtlas().findRegion("idle"));
        player1Idle.flip(true,false);
        player1Jump = new TextureRegion(screen.getAtlas().findRegion("jump"));
        player1Jump.flip(true,false);
        player1Plunge = new TextureRegion(screen.getAtlas().findRegion("lunge"));
        player1Plunge.flip(true,false);
        definePlayer2();
        //sprite = new Sprite();
//        idle = (Texture)

        //sprite = new Sprite(player1Idle);
        //setPosition(1,1);
        setBounds(0, 0, 32, 32);
        //setRegion(sprite);
    }

    public void update(float dt) {
        setPosition(body.getPosition().x, body.getPosition().y);
        setRegion(getFrame(dt));
    }

    public TextureRegion getFrame(float dt) {
        TextureRegion region;
        currentState = getState();
        switch (currentState) {
            case Jumping:
                region = player1Jump;
                break;
            case Idle:
                region = player1Idle;
                break;
            case Lunge:
                region = player1Plunge;
                break;
            default:
                region = player1Idle;
                break;
        }
        return region;
    }

    public State getState() {
        if (body.getPosition().y <= 17.041664)
            currentState = State.Jumping;
        return currentState;
    }

    public void setRoundsWon(int roundsWon) {
        this.roundsWon = roundsWon;
    }

    public void setMatchOver(boolean matchOver) {
        this.matchOver = matchOver;
    }

    public int getRoundsWon() {
        return roundsWon;
    }

    public boolean isMatchOver() {
        return matchOver;
    }

    private void definePlayer2() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(3, 22);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bodyDef);
        FixtureDef fixtureDef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(16);
        fixtureDef.shape = shape;
        body.createFixture(fixtureDef);
    }
}
