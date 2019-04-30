package dev.shashwat.tilegame.dev.shashwat.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
    private static final int height = 150;
    private static final int width = 200;
    public static BufferedImage road,flag, grass,bar, gas, firstLane, middleLane, lastLane, bushGrass, playerCar, pressStart, cars[],explosion[],gameOver[];

    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/explosionsprite.png"));
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/gameover.png"));
        cars = new BufferedImage[4];
        explosion = new BufferedImage[5];
        gameOver = new BufferedImage[2];
        road = ImageLoader.loadImage("/textures/road.jpg");
        grass = ImageLoader.loadImage("/textures/grass.jpg");
        firstLane = ImageLoader.loadImage("/textures/firstLane.jpg");
        lastLane = ImageLoader.loadImage("/textures/lastLane.jpg");
        middleLane = ImageLoader.loadImage("/textures/middleLane.jpg");
        bushGrass = ImageLoader.loadImage("/textures/bushgrass.png");
        playerCar = ImageLoader.loadImage("/textures/playercar.png");
        cars[0] = ImageLoader.loadImage("/textures/car1.png");
        cars[1] = ImageLoader.loadImage("/textures/car3.png");
        cars[2] = ImageLoader.loadImage("/textures/car4.png");
        cars[3] = ImageLoader.loadImage("/textures/car5.png");
        explosion[0] = sheet.getSubpart(0,0,250,250);
        explosion[1] = sheet.getSubpart(250,0,250,250);
        explosion[2] = sheet.getSubpart(500,0,250,250);
        explosion[3] = sheet.getSubpart(750,0,250,250);
        explosion[4] = sheet.getSubpart(0,0,5,5);
        gameOver[0] = sheet2.getSubpart(0,0,1000,410);
        gameOver[1] = sheet2.getSubpart(0,0,10,10);
        pressStart = ImageLoader.loadImage("/textures/pressstart.gif");
        gas = ImageLoader.loadImage("/textures/gaspump.png");
        bar = ImageLoader.loadImage(("/textures/healthbar.png"));
        flag = ImageLoader.loadImage("/textures/flag.png");
        }

}