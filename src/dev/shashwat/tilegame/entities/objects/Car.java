package dev.shashwat.tilegame.entities.objects;

import dev.shashwat.tilegame.Handler;
import dev.shashwat.tilegame.dev.shashwat.tilegame.gfx.Assets;
import dev.shashwat.tilegame.tiles.Tile;

import java.awt.*;
import java.util.Random;

public class Car extends Objects {
    public boolean shouldCheck = true;
    private int car;
    Random rand = new Random();
    public Car(Handler handler) {
        super(handler, 0, 0, Objects.DEFAULT_OBJECT_WIDTH, Objects.DEFAULT_OBJECT_HEIGHT);
        bounds.x = 20;
        bounds.y = 5;
        bounds.width = 120;
        bounds.height = 55;
        car = rand.nextInt(Assets.cars.length);
        }

    @Override
    public void tick() {
        if (shouldCheck) {
            setVars();
        }
        x+=1;
    }

    public void xMove(){
        xMove = 5;
    }

    public void yMove(){
        yMove = rand.nextInt(3);
    }
    public void setVars(){
        do {
            x = rand.nextInt((handler.getWorld().getWidth() - 1) * Tile.TILE_WIDTH) + Tile.TILE_WIDTH;
            y = rand.nextInt(Tile.TILE_HEIGHT * (handler.getWorld().getHeight() - 3) - Tile.TILE_HEIGHT * (2)) + Tile.TILE_HEIGHT * 2;
        }while(checkEntityCollisions(0,0));
        shouldCheck = false;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.cars[car],(int)(x-handler.getGameCamera().getxOffset()),(int)(y),width,height,null);
       // g.fillRect((int)(x+bounds.x-handler.getGameCamera().getxOffset()),(int)y+bounds.y,bounds.width,bounds.height);
    }
}
