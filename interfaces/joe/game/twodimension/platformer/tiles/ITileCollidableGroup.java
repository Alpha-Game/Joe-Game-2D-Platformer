package joe.game.twodimension.platformer.tiles;

import java.util.Collection;

import joe.game.twodimension.platformer.layer.ILayerObject;
import joe.game.twodimension.platformer.physics.ICollidableObject;

public interface ITileCollidableGroup extends ILayerObject, ICollidableObject {
	Collection<ICollidableTileManager> getTiles();
	boolean addTile(ICollidableTileManager... tiles);
	boolean addTile(Collection<ICollidableTileManager> tiles);
	Collection<ICollidableTileManager> removeTile(String... tileIDs);
	Collection<ICollidableTileManager> removeTile(ICollidableTileManager... tiles);
	Collection<ICollidableTileManager> removeTile(Collection<Object> tileIDs);
}
