package joe.game.twodimension.platformer.match;

import joe.game.base.IUpdateableObject;
import joe.game.twodimension.platformer.base.IDrawableObject;

public interface IMatchObject extends IDrawableObject, IUpdateableObject {
	IMatchManager getMatchManager();
}
