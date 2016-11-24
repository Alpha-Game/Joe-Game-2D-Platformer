package joe.game.twodimension.platformer.tiles;

import joe.game.base.settings.ICreator;
import joe.game.twodimension.platformer.layer.ILayerManager;

public interface ITileCreator<R extends ITileManager> extends ICreator<ILayerManager, R> {
	
}
