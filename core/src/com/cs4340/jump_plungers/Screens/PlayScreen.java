package com.cs4340.jump_plungers.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.cs4340.jump_plungers.JumpPlungers;
import com.cs4340.jump_plungers.Scenes.Hud;
import com.cs4340.jump_plungers.Scenes.Player1Controller;
import com.cs4340.jump_plungers.Scenes.Player2Controller;
//import android.util.log;

public class PlayScreen implements Screen {
    private JumpPlungers game;
    //Texture texture;
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    private OrthographicCamera gameCam;
    private Viewport gamePort;

    private World world;
    private Box2DDebugRenderer b2dr;

    private Hud hud;
    private Player1Controller p1C;
    private Player2Controller p2C;

    private Music music;

    public PlayScreen(JumpPlungers game){
        //spriteBatch = new SpriteBatch();
        this.game = game;
        //texture = new Texture("badlogic.jpg");
        gameCam = new OrthographicCamera();

        gamePort = new FitViewport(JumpPlungers.vWidth,JumpPlungers.vHeight,gameCam); //screen size with camera
        gamePort.apply();
        gameCam.setToOrtho(false,Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
        hud = new Hud(game.batch);
        p1C = new Player1Controller(game.batch);

        p2C = new Player2Controller(game.batch);
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("Map1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        gameCam.position.set(gamePort.getWorldWidth() /2,gamePort.getWorldHeight()/2,0);

        world = new World(new Vector2(0,0),true); //vector 2 is our gravity, setting everything to sleep unless pressed
        b2dr = new Box2DDebugRenderer();

        music = JumpPlungers.manager.get("Audio/fightone_160bpm.mp3",Music.class);
        music.setLooping(true);
        music.setVolume(0.3f);
        music.play();

        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        for(MapObject object: map.getLayers().get(1).getObjects().getByType(RectangleMapObject.class) ) {
            Rectangle rectangle = ((RectangleMapObject) object).getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set(rectangle.getX() / 2, rectangle.getY());
            body = world.createBody(bdef);

            shape.setAsBox(rectangle.getWidth() / 2, rectangle.getHeight() / 2);
            fdef.shape = shape;
            body.createFixture(fdef);
        }
        //Creating hitboxes for invisible walls
        for(MapObject object: map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class) ){
            Rectangle rectangle = ((RectangleMapObject)object).getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set(rectangle.getX()/2,rectangle.getY()/2);
            body = world.createBody(bdef);

            shape.setAsBox(rectangle.getWidth()/2,rectangle.getHeight()/2);
            fdef.shape = shape;
            body.createFixture(fdef);

        }

    }
    @Override
    public void show() {

    }
    public void handleInput(float delta){
        if(Gdx.input.isTouched()){
            gameCam.position.x+=400*delta;
            System.out.println(gameCam.position.x);
        }

    }
    public void update(float delta){
        handleInput(delta);
        gameCam.update();
        renderer.setView(gameCam);

    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();

        b2dr.render(world,gameCam.combined.scale(2,2,0));

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.act(delta);
        //spriteBatch.setProjectionMatrix(hud.stage.getCamera().combined);
        // hud.stage.act(delta);
        hud.stage.draw();

        game.batch.setProjectionMatrix(Player1Controller.stage.getCamera().combined);
        Player1Controller.stage.act(delta);
        Player1Controller.stage.draw();

        game.batch.setProjectionMatrix(Player2Controller.stage.getCamera().combined);
        Player2Controller.stage.act(delta);
        Player2Controller.stage.draw();

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
