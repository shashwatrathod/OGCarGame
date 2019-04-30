package dev.shashwat.tilegame.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    public static Tile[] tiles = new Tile[256];
    public static Tile firstLaneTile = new FirstLaneTile(0);
    public static Tile middleLaneTile = new MiddleLaneTile(1);
    public static Tile lastLaneTile = new LastLaneTile(2);
    public static Tile grassTile = new GrassTile(3);
    public static Tile roadTile = new RoadTile(4);
    public static Tile bushGrass = new BushGrassTile(5);
    public static Tile flagTile = new FlagTile(6);



    protected BufferedImage texture;
    protected final int id;

    public static final int TILE_WIDTH = 120, TILE_HEIGHT = 106;

    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;
        tiles[id] = this;
    }

    public void render(Graphics g,int x, int y){
        g.drawImage(texture,x,y,TILE_WIDTH,TILE_HEIGHT,null);
    }

    public boolean isFinish(){
        return false;
    }

    public boolean isSolid(){
        return false;
    }

    public int getId() {
        return id;
    }
}
