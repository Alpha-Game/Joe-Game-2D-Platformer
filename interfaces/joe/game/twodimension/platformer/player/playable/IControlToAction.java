package joe.game.twodimension.platformer.player.playable;

import java.util.Collection;

import joe.game.base.action.IAction;

public interface IControlToAction {
	Collection<IAction> getAction(Collection<IControl> controls);
}
