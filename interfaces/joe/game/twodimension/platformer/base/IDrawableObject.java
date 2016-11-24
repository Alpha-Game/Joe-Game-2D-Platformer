package joe.game.twodimension.platformer.base;

import java.awt.Graphics2D;

public interface IDrawableObject {
	/**
	 * Draws an object to the graphic
	 * 
	 * @param time Time in nanoseconds since the object was last drawn
	 * @param graphics The median to draw the object on
	 */
	void draw(long time, Graphics2D graphics);
}
