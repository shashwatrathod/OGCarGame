package dev.shashwat.tilegame.states;

import dev.shashwat.tilegame.Handler;
import dev.shashwat.tilegame.dev.shashwat.tilegame.gfx.Animation;
import dev.shashwat.tilegame.dev.shashwat.tilegame.gfx.Assets;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class OverState extends State{
    private Color myColor;
    private Font myFont;
    private Animation gameOver;
    public OverState(Handler handler) {
        super(handler);
        gameOver = new Animation(1000,Assets.gameOver);
        myColor = new Color(0,0,0,0.7f);
        try {
            myFont = Font.createFont(Font.TRUETYPE_FONT,new File("res/fonts/bit.ttf")).deriveFont(Font.PLAIN, 28);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void tick() {
        handler.getWorld().getEntityManager().tick();
        gameOver.tick();
        if(handler.getGame().getKeyManager().start){
            State.setCurrentState(new GameState(handler));
        }
    }

    @Override
    public void render(Graphics g) {
        handler.getWorld().render(g);
        g.setColor(myColor);
        g.fillRect(0,0,handler.getWIDTH(),handler.getHEIGHT());
        g.drawImage(gameOver.getCurrentFrame(),300,handler.getHEIGHT()/2 - 150,(int)(1000/1.5f),(int)(410/1.5),null);
        g.setFont(myFont);
        g.setColor(Color.WHITE);
        g.drawString("PRESS ENTER TO CONTINUE",317,handler.getHEIGHT()/2 + 180);
    }
}
