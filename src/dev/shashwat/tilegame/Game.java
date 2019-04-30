package dev.shashwat.tilegame;

import dev.shashwat.tilegame.dev.shashwat.tilegame.gfx.Assets;
import dev.shashwat.tilegame.dev.shashwat.tilegame.gfx.GameCamera;
import dev.shashwat.tilegame.display.Display;
import dev.shashwat.tilegame.input.KeyManager;
import dev.shashwat.tilegame.states.MenuState;
import dev.shashwat.tilegame.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;


public class Game implements Runnable{
    private Display display;
    private int WIDTH;
    private int HEIGHT;
    private String TITLE;
    private boolean running;
    private BufferStrategy bs;
    private Graphics g;
    private Thread thread;
    private State menuState;
    private KeyManager keyManager;
    private GameCamera gameCamera;
    private Handler handler;

    public Game(String TITLE, int WIDTH, int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.TITLE = TITLE;
        keyManager = new KeyManager();
    }
    public void init(){
        display = new Display(TITLE,WIDTH,HEIGHT);
        handler = new Handler(this);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();
        gameCamera = new GameCamera(handler,0,0);
        menuState = new MenuState(handler);
        State.setCurrentState(menuState);
    }
    public void tick(){
        keyManager.tick();
        if(State.getCurrentState()!=null){
            State.getCurrentState().tick();
        }
    }
    public void render() {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        g.clearRect(0,0,WIDTH,HEIGHT);

        //start draw
        State.getCurrentState().render(g);
        //end
       bs.show();
       g.dispose();

    }
    public void run(){
        init();
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        long ticks = 0;
      
        while(running) {
        	now = System.nanoTime();
        	delta += (now-lastTime) / timePerTick; 
        	timer += now - lastTime ; 
        	lastTime  = now ;
        	
        	if(delta>=1) {
        		tick();
        		render();
        		ticks++;
        		delta--;
        	}
        	
        	if(timer>1000000000) {
        		System.out.println("FPS: "+ticks);
        		ticks = 0;
        		timer = 0;
        	}
        }
        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public synchronized void start(){
        if(!running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }
    public synchronized void stop(){
        if(running) {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }
}
