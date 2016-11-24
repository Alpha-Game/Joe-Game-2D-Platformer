package joe.game.twodimension.platformer.physics;

import joe.classes.geometry2D.IShape2D;
import joe.classes.geometry2D.Rectangle2D;
import joe.classes.identifier.IMappable;

public interface ICollidableObject extends IMappable {
	boolean canCollideWith(ICollidableObject object);
	Rectangle2D getCollisionBoundRectangle();
	IShape2D getCollisionShape();
}
