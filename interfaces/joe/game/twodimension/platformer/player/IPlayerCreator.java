package joe.game.twodimension.platformer.player;

import joe.game.base.settings.ICreator;
import joe.game.twodimension.platformer.match.IMatchManager;

public interface IPlayerCreator<R extends IPlayerManager> extends ICreator<IMatchManager, R> {
	
}
