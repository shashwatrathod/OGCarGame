package dev.shashwat.tilegame.states;


import java.awt.Graphics;

import dev.shashwat.tilegame.Game;
import dev.shashwat.tilegame.Handler;
import dev.shashwat.tilegame.entities.objects.Player;
import dev.shashwat.tilegame.tiles.Tile;
import dev.shashwat.tilegame.world.World;

public class GameState extends State {

	private World world;

	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
	}

	@Override
	public void tick() {
		world.tick();
		if (handler.getGameCamera().getxOffset() >= 0 &&
		handler.getGameCamera().getxOffset() < handler.getWorld().getWidth()* Tile.TILE_WIDTH - handler.getWIDTH() &&
		!handler.getWorld().getEntityManager().getPlayer().isDead()) {
			handler.getGameCamera().move(6, 0);
		}
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

	public World getWorld() {
		return world;
	}
}
