package dev.shashwat.tilegame.tiles;

import dev.shashwat.tilegame.dev.shashwat.tilegame.gfx.Assets;

import java.awt.image.BufferedImage;

public class GrassTile extends Tile {
    public GrassTile(int id) {
        super(Assets.grass, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
