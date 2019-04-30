package dev.shashwat.tilegame.entities;

import dev.shashwat.tilegame.Handler;
import dev.shashwat.tilegame.states.OverState;
import dev.shashwat.tilegame.states.State;
import dev.shashwat.tilegame.tiles.Tile;

import java.awt.*;

public abstract class Entity {
    protected Handler handler;
    protected float x,y;
    protected int width, height;
    protected Rectangle bounds;
    public boolean shouldTick = true;
    public boolean shouldRender = true;

    public Entity(Handler handler, float x, float y, int width, int height) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.bounds = new Rectangle(0,0,width,height);
    }
    public boolean checkEntityCollisions(float xOffset, float yOffset){
        for(Entity e: handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))){
                if(this == handler.getWorld().getEntityManager().getPlayer()) {
                    if(e.isPump()){
                        handler.getWorld().getEntityManager().getPlayer().addFuel(25* Tile.TILE_WIDTH);
                        e.shouldRender = false;
                    }else {
                        handler.getWorld().getEntityManager().getPlayer().setDead(true);
                        State.setCurrentState(new OverState(handler));
                    }
                }else{
                    return true;
                }
            }
        }
        return false;
    }

    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        if(this != handler.getWorld().getEntityManager().getPlayer())
            return new Rectangle((int)(x + bounds.x - handler.getGameCamera().getxOffset() + xOffset),(int)(y + bounds.y + yOffset),bounds.width,bounds.height);
        return new Rectangle((int)(x + bounds.x + xOffset),(int)(y + bounds.y + yOffset),bounds.width,bounds.height);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }
    public boolean isPump(){
        return false;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public abstract void tick();

    public abstract void render(Graphics g);
}
