package joe.game.twodimension.platformer.tiles;

import java.util.Collection;

import joe.game.twodimension.platformer.layer.ILayerObject;

public interface ITileDrawableGroup extends ILayerObject {
	Collection<IDrawableTileManager> getTiles();
	boolean addTile(IDrawableTileManager... tiles);
	boolean addTile(Collection<IDrawableTileManager> tiles);
	Collection<IDrawableTileManager> removeTile(String... tileIDs);
	Collection<IDrawableTileManager> removeTile(IDrawableTileManager... tiles);
	Collection<IDrawableTileManager> removeTile(Collection<String> tileIDs);
}
