package dev.shashwat.tilegame.entities.objects;

import dev.shashwat.tilegame.Handler;
import dev.shashwat.tilegame.dev.shashwat.tilegame.gfx.Animation;
import dev.shashwat.tilegame.dev.shashwat.tilegame.gfx.Assets;
import dev.shashwat.tilegame.states.OverState;
import dev.shashwat.tilegame.states.State;
import dev.shashwat.tilegame.tiles.Tile;

import java.awt.*;

public class Player extends Objects {
    private boolean dead = false;
    private Animation explode;
    private int fuel;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Objects.DEFAULT_OBJECT_WIDTH, Objects.DEFAULT_OBJECT_HEIGHT);
        bounds.x = 20;
        bounds.y = 5;
        bounds.width = 120;
        bounds.height = 55;
        explode = new Animation(250,Assets.explosion);
        this.fuel = 70 * Tile.TILE_WIDTH;
    }

    @Override
    public void tick(){
        explode.tick();
        if(!dead) {
            getInput();
            move();
            decrementFuel();
            if(fuel<=0){
                dead = true;
                State.setCurrentState(new OverState(handler));
            }
            int tx = (int)(x + xMove + bounds.width + bounds.x) / Tile.TILE_WIDTH;
            if(collisionWithFinish((int)(tx-handler.getGameCamera().getxOffset()),(int)(y+bounds.y)/Tile.TILE_WIDTH) ||
                    collisionWithFinish(tx,(int)(y+bounds.y+bounds.height)/Tile.TILE_HEIGHT)) {
                State.setCurrentState(new OverState(handler));
            }
        }
    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up)
            yMove = -speed;
        if(handler.getKeyManager().down)
            yMove = speed;
        if(handler.getKeyManager().left)
            xMove = -speed;
        if(handler.getKeyManager().right && x < handler.getWIDTH()-150)
            xMove = speed;
    }


    @Override
    public void render(Graphics g){
        if(!dead) {
            g.drawImage(Assets.playerCar, (int) (x), (int) y, width, height, null);
        }else{
            if(explode.getIndex() < Assets.explosion.length)
                g.drawImage(explode.getCurrentFrame(),(int) (x), (int) y, width-20, width-20, null);
        }
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public void decrementFuel(){
        this.fuel = this.fuel - (int)(6+xMove);
    }
    public void addFuel(int amnt){
        if(this.fuel + amnt > 100*Tile.TILE_WIDTH){
            this.fuel = 100*Tile.TILE_WIDTH;
        }
        this.fuel += amnt;
    }
}
