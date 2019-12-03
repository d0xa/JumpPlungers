package com.cs4340.jump_plungers.tools;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapImageLayer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.cs4340.jump_plungers.JumpPlungers;

public class b2worldCreator {
    public b2worldCreator(World world, TiledMap map){
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        //creating ground fixtures
        for(MapObject object: map.getLayers().get(1).getObjects().getByType(RectangleMapObject.class) ) {
            Rectangle rectangle = ((RectangleMapObject) object).getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rectangle.getX() / 2)/ JumpPlungers.PPM, (rectangle.getY())/JumpPlungers.PPM);
            body = world.createBody(bdef);

            shape.setAsBox((rectangle.getWidth() / 2)/JumpPlungers.PPM, (rectangle.getHeight() / 2)/JumpPlungers.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);
        }
        //Creating hitboxes for invisible walls
        for(MapObject object: map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class) ){
            Rectangle rectangle = ((RectangleMapObject)object).getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rectangle.getX()/2)/JumpPlungers.PPM,(rectangle.getY()/2)/JumpPlungers.PPM);
            body = world.createBody(bdef);

            shape.setAsBox((rectangle.getWidth()/2)/JumpPlungers.PPM,(rectangle.getHeight()/2)/JumpPlungers.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);

        }
    }
}
