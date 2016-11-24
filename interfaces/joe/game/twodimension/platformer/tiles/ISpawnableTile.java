package joe.game.twodimension.platformer.tiles;

import joe.classes.geometry2D.IShape2D;

public interface ISpawnableTile extends ITileManager {
	IShape2D getSpawnLocation();
}
