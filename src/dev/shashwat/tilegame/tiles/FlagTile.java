package dev.shashwat.tilegame.tiles;

import dev.shashwat.tilegame.dev.shashwat.tilegame.gfx.Assets;

import java.awt.image.BufferedImage;

public class FlagTile extends  Tile{
    public FlagTile(int id) {
        super(Assets.flag, id);
    }

    @Override
    public boolean isFinish() {
        return true;
    }
    public boolean isSolid(){
        return true;
    }
}
