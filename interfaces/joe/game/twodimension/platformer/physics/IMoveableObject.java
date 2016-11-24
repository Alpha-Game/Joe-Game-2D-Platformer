package joe.game.twodimension.platformer.physics;

import joe.classes.geometry2D.IShape2D;
import joe.classes.geometry2D.Rectangle2D;

public interface IMoveableObject extends ICollidableObject {
	Rectangle2D getLastCollisionBoundRectangle();
	IShape2D getLastCollisionShape();
}
