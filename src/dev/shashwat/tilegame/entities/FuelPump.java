package dev.shashwat.tilegame.entities;

import dev.shashwat.tilegame.Handler;
import dev.shashwat.tilegame.dev.shashwat.tilegame.gfx.Assets;

import java.awt.*;
import java.util.Random;

public class FuelPump extends Entity {
    private Random rand = new Random();

    public FuelPump(Handler handler, float x, float y) {
        super(handler, x, y,80, 80);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        if(shouldRender)
            g.drawImage(Assets.gas,(int)(x-handler.getGameCamera().getxOffset()),(int)y,width,height,null);
    }

    public boolean isPump(){
        return true;
    }

}
