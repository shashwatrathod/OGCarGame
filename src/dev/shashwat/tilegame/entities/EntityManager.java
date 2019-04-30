package dev.shashwat.tilegame.entities;

import dev.shashwat.tilegame.Handler;
import dev.shashwat.tilegame.entities.objects.Player;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {
    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;

    public EntityManager(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>();
        addEntity(player);
    }

    public void addEntity(Entity e){
        entities.add(e);
    }

    public void tick(){
        for(int i=0;i <entities.size();i++){
            if(entities.get(i).shouldTick) {
                entities.get(i).tick();
            }
        }
    }
    public void render(Graphics g){
        for (Entity e:
             entities) {
            e.render(g);
        }
    }

    public Handler getHandler() {
        return handler;
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }
}
