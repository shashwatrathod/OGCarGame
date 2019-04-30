package dev.shashwat.tilegame.world;

import dev.shashwat.tilegame.Handler;
import dev.shashwat.tilegame.dev.shashwat.tilegame.gfx.FuelCounter;
import dev.shashwat.tilegame.entities.EntityManager;
import dev.shashwat.tilegame.entities.FuelPump;
import dev.shashwat.tilegame.entities.objects.Car;
import dev.shashwat.tilegame.entities.objects.Player;
import dev.shashwat.tilegame.tiles.Tile;
import dev.shashwat.tilegame.utils.Utils;

import java.awt.*;
import java.util.Random;

public class World {
    private Random rand = new Random();
    private Handler handler;
    private int width, height;
    private int[][] idAtPos;
    private EntityManager entityManager;
    private FuelCounter counter;

    public World(Handler handler, String path) {
        this.handler = handler;
        entityManager = new EntityManager(handler,new Player(handler,60,handler.getHEIGHT()/2-34));
        loadWorld(path);
        for(int i=0;i<15;i++)
            entityManager.addEntity(new Car(handler));
        entityManager.addEntity(new FuelPump(handler,
                (float)rand.nextInt(50*Tile.TILE_WIDTH - 30*Tile.TILE_WIDTH)+30*Tile.TILE_WIDTH,
                (float) rand.nextInt(Tile.TILE_HEIGHT * (getHeight() - 3) - Tile.TILE_HEIGHT * (2)) + Tile.TILE_HEIGHT * 2));
        entityManager.addEntity(new FuelPump(handler,
                (float)rand.nextInt(70*Tile.TILE_WIDTH - 50*Tile.TILE_WIDTH)+50*Tile.TILE_WIDTH,
                (float) rand.nextInt(Tile.TILE_HEIGHT * (getHeight() - 3) - Tile.TILE_HEIGHT * (2)) + Tile.TILE_HEIGHT * 2));
        entityManager.addEntity(new FuelPump(handler,
                (float)rand.nextInt(70*Tile.TILE_WIDTH - 50*Tile.TILE_WIDTH)+50*Tile.TILE_WIDTH,
                (float) rand.nextInt(Tile.TILE_HEIGHT * (getHeight() - 3) - Tile.TILE_HEIGHT * (2)) + Tile.TILE_HEIGHT * 2));
        counter = new FuelCounter(handler);
    }
    public void tick(){
        entityManager.tick();
        counter.tick();
    }
    public void render(Graphics g){
        int xStart=(int)Math.max(0, handler.getGameCamera().getxOffset()/Tile.TILE_WIDTH);
        int xEnd = (int)Math.min(width,(handler.getGameCamera().getxOffset()+ handler.getWIDTH())/Tile.TILE_WIDTH + 1);
        for(int y=0;y<height;y++){
            for(int x=xStart;x<xEnd;x++){
                getTile(x,y).render(g,(int)(x*Tile.TILE_WIDTH- handler.getGameCamera().getxOffset()),(int)(y*Tile.TILE_HEIGHT));
            }
        }
        entityManager.render(g);
        counter.render(g);
    }

    public int[][] getIdAtPos() {
        return idAtPos;
    }

    public Tile getTile(int x, int y){
        if(x<0 || y < 0 || x > width || y > width)
            return Tile.grassTile;

        Tile t = Tile.tiles[idAtPos[x][y]];
        if(t==null)
            return Tile.grassTile;

        return t;
    }
    public World getWorld(){
        return this;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        idAtPos = new int[width][height];
        for(int x = 0;x<width;x++){
            for(int y=0;y<height;y++){
                idAtPos[x][y] = Utils.parseInt(tokens[(x+y*width)+4]);
            }
        }
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
