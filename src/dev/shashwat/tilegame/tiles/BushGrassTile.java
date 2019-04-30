package dev.shashwat.tilegame.tiles;

import dev.shashwat.tilegame.dev.shashwat.tilegame.gfx.Assets;

import java.awt.image.BufferedImage;

public class BushGrassTile extends Tile {

    public BushGrassTile(int id) {
        super(Assets.bushGrass, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
