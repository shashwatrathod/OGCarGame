package dev.shashwat.tilegame;

import dev.shashwat.tilegame.dev.shashwat.tilegame.gfx.GameCamera;
import dev.shashwat.tilegame.input.KeyManager;
import dev.shashwat.tilegame.world.World;

public class Handler {
    private Game game;
    private World world;

    Handler(Game game){
        this.game = game;
    }
     public GameCamera getGameCamera(){
        return game.getGameCamera();
     }
     public KeyManager getKeyManager(){
        return game.getKeyManager();
     }
     public int getHEIGHT(){
        return game.getHEIGHT();
    }
    public int getWIDTH(){
        return game.getWIDTH();
    }


    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
