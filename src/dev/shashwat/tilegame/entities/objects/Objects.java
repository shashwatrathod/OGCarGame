package dev.shashwat.tilegame.entities.objects;

import dev.shashwat.tilegame.Handler;
import dev.shashwat.tilegame.entities.Entity;
import dev.shashwat.tilegame.tiles.Tile;

public abstract class Objects extends Entity {
   public static final float DEFAULT_SPEED = 3.0f;
   public static final int DEFAULT_OBJECT_WIDTH = 128;
   public static final int DEFAULT_OBJECT_HEIGHT = 64;

  // protected int health;
   protected float speed;
   protected float xMove, yMove;

    public Objects(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        //this.health = DEFAULT_HEALTH;
        this.speed = DEFAULT_SPEED;
    }

    public void move(){
        if(!checkEntityCollisions(xMove,0f))
             xMove();
        if(!checkEntityCollisions(0f,yMove))
             yMove();
    }
     public void xMove(){

        if(xMove > 0){
            int tx = (int)(x + xMove + bounds.width + bounds.x) / Tile.TILE_WIDTH;
            if(!collisionWithTile(tx,(int)(y+bounds.y)/Tile.TILE_HEIGHT) &&
                    !collisionWithTile(tx,(int)(y+bounds.y+bounds.height)/Tile.TILE_HEIGHT)){
                x += xMove;
            }
        }else if(xMove < 0){
            int tx = (int)(x + xMove + bounds.x) / Tile.TILE_WIDTH;

            if(!collisionWithTile(tx,(int)(y+bounds.y)/Tile.TILE_HEIGHT) &&
                    !collisionWithTile(tx,(int)(y+bounds.y+bounds.height)/Tile.TILE_HEIGHT)){
                x += xMove;
            }
        }
     }

    public void yMove(){
        if(yMove>0){
            int ty = (int)(y+bounds.y+bounds.height+yMove)/Tile.TILE_HEIGHT;
            if(!collisionWithTile((int)(x+bounds.x)/Tile.TILE_WIDTH,ty) && !collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TILE_WIDTH,ty)){
                y += yMove;
            }
        }else if(yMove<0){
            int ty = (int)(y+ bounds.y + yMove)/Tile.TILE_HEIGHT;
            if(!collisionWithTile((int)(x+bounds.x)/Tile.TILE_WIDTH,ty) && !collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TILE_WIDTH,ty)){
                y += yMove;
            }
        }
    }

     private boolean collisionWithTile(int x,int y){
        return handler.getWorld().getTile(x,y).isSolid() || handler.getWorld().getTile(x,y).isFinish();
     }
     private boolean isFinish(int x, int y){
        return handler.getWorld().getTile(x,y).isFinish();
     }
     public boolean collisionWithFinish(int x, int y){
        if(handler.getWorld().getTile(x,y).getId() == 6){
            return true;
        }
        else
            return false;
     }


    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
