package dev.shashwat.tilegame.dev.shashwat.tilegame.gfx;

import dev.shashwat.tilegame.Game;
import dev.shashwat.tilegame.Handler;
import dev.shashwat.tilegame.entities.Entity;
import dev.shashwat.tilegame.tiles.Tile;

public class GameCamera {
    private Handler handler;
    private float xOffset, yOffset;

    public GameCamera(Handler handler, float xOffset, float yOffset) {
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
    public void move(float xAmnt, float yAmnt){
        xOffset += xAmnt;
        yOffset += yAmnt;
    }
    public void checkBlankSpace(){
        if(xOffset < 0){
            xOffset = 0;
        }else if(xOffset > handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWIDTH()){
            xOffset = handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWIDTH();
        }
    }

    public void centreOnEntity(Entity e){
        xOffset = e.getX() - handler.getWIDTH() / 5 + e.getWidth() / 2;
        checkBlankSpace();
    }

    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}
