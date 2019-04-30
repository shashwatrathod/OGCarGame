package dev.shashwat.tilegame.dev.shashwat.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Animation {
    private int speed, index;
    private long lastTime, timer = 0;
    private BufferedImage[] frames;

    public Animation(int speed, BufferedImage[] frames){
        this.speed = speed;
        this.frames = frames;
        lastTime = System.currentTimeMillis();
    }

    public void tick(){
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        if(timer > speed){
            index++;
            timer = 0;
            if(index>=frames.length){
                index = 0;
            }
        }
    }

    public int getIndex() {
        return index;
    }

    public BufferedImage getCurrentFrame(){
        return frames[index];
    }
}
