package dev.shashwat.tilegame.dev.shashwat.tilegame.gfx;

import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class SpriteSheet {
    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }

    public BufferedImage getSubpart(int x, int y, int width, int height){
        return sheet.getSubimage(x,y,width,height);
    }
}
