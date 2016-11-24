package joe.game.twodimension.platformer.layer;

import joe.game.base.settings.ICreator;
import joe.game.twodimension.platformer.match.IMatchObject;

public interface ILayerCreator<R extends ILayerManager> extends ICreator<IMatchObject, R> {
	
}
