package dev.shashwat.tilegame.tiles;

import dev.shashwat.tilegame.dev.shashwat.tilegame.gfx.Assets;

import java.awt.image.BufferedImage;

public class MiddleLaneTile extends Tile {
    public MiddleLaneTile(int id) {
        super(Assets.middleLane, id);
    }

    @Override
    public boolean isSolid() {
        return super.isSolid();
    }
}
