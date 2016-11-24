package joe.game.twodimension.platformer.player;

import java.util.Collection;

import joe.classes.identifier.IMappable;
import joe.game.twodimension.platformer.tiles.ISpawnableTile;

public interface ISpawnableObject extends IMappable {
	boolean addSpawnTile(IMappable callingObject, ISpawnableTile... tiles);
	boolean addSpawnTile(IMappable callingObject, Collection<ISpawnableTile> tiles);
	
	boolean removeSpawnTile(IMappable callingObject, String... tileIDs);
	boolean removeSpawnTile(IMappable callingObject, ISpawnableTile... tiles);
	boolean removeSpawnTile(IMappable callingObject, Collection<Object> tileIDs);
}
