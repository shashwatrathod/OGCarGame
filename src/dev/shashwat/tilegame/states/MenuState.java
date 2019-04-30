package dev.shashwat.tilegame.states;

import dev.shashwat.tilegame.Handler;
import dev.shashwat.tilegame.dev.shashwat.tilegame.gfx.Assets;

import java.awt.*;

public class MenuState extends State{

    public MenuState(Handler handler) {
        super(handler);
    }

    @Override
    public void tick() {
        if (handler.getGame().getKeyManager().start){
            State.setCurrentState(new GameState(handler));
        }

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,handler.getWIDTH(),handler.getHEIGHT());
        g.drawImage(Assets.pressStart,425,(int)(handler.getHEIGHT()/2-250),400,400,null);
    }
}
