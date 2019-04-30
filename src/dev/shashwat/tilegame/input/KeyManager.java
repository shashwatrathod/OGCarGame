package dev.shashwat.tilegame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
    protected boolean[] keys;
    public boolean up,down,left,right,start;

    public void tick(){
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        start = keys[KeyEvent.VK_ENTER];
    }

    public KeyManager() {
        keys = new boolean[256];
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    public boolean isPressed(){
        for(int i=0;i<keys.length;i++){
            if(keys[i] = true)
                return true;
        }
        return false;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        keys[keyEvent.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        keys[keyEvent.getKeyCode()] = false;
    }
}
