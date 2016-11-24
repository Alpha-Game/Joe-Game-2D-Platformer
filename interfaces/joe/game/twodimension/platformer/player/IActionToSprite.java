package joe.game.twodimension.platformer.player;

import java.util.Collection;

import joe.game.base.action.IAction;
import joe.game.layout.image.sprite.ISprite;

public interface IActionToSprite {
	Collection<ISprite> getSprite(Collection<IAction> actions);
}
