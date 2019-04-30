package dev.shashwat.tilegame.dev.shashwat.tilegame.gfx;

import dev.shashwat.tilegame.Handler;
import dev.shashwat.tilegame.tiles.Tile;

import java.awt.*;

public class FuelCounter {
    private Handler handler;
    private boolean shouldCheck = true;
    private int x,y,width,height;
    private int xOffset;
    public FuelCounter(Handler handler){
        this.handler = handler;
        x = 450;
        y = 70;
    }
    public void tick(){
        if(shouldCheck)
            setVars();
        xOffset = handler.getWorld().getEntityManager().getPlayer().getFuel()/Tile.TILE_WIDTH;
    }

    public void render(Graphics g){
        g.drawImage(Assets.bar,x,y,width,height,null);
        g.setColor(Color.ORANGE);
        g.fillRect(x+3,y+3,xOffset,height-8);
        g.drawImage(Assets.gas,x+xOffset - 20,y-10,50,50,null);
    }

    private void setVars(){
        width = 150;
        height = 30;
        shouldCheck=false;
    }
}
