package joe.game.twodimension.platformer.tiles;

import joe.game.twodimension.platformer.physics.ICollidableObject;

public interface ICollidableTileManager extends ITileManager, ICollidableObject {
	void setTileCollidableGroup(ITileCollidableGroup group);
	ITileCollidableGroup getTileCollidableGroup();
	boolean isBoundRectangleChanged();
}
