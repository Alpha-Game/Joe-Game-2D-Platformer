package joe.game.platformer.physics;

import joe.classes.constants.GlobalConstants;
import joe.classes.geometry2D.Rectangle2D;

public class PhysicsCalculator {
	public static double getValue(double valueX, double valueY) {
		return Math.pow((valueX * valueX) + (valueY * valueY), 0.5);
	}
	
	public static double getAngleInDegrees(double valueX, double valueY) {
		return Math.toDegrees(Math.atan(valueY/valueX));
	}
	
	public static double getValueX(double value, double angleInDegreesFromXAxis) {
		if ((angleInDegreesFromXAxis % 90 == 0) && (angleInDegreesFromXAxis % 180 != 0)) {
			return 0.0;
		}
		return value * Math.cos(Math.toRadians(angleInDegreesFromXAxis));
	}
	
	public static double getValueY(double value, double angleInDegreesFromXAxis) {
		if (angleInDegreesFromXAxis % 180 == 0) {
			return 0.0;
		}
		return value * Math.sin(Math.toRadians(angleInDegreesFromXAxis));
	}
	
	public static double getTime(long time) {
		return ((double)time / (double)GlobalConstants.NANOSECONDS);
	}
	
	public static double getNextPosition(double initialPosition, double initalVelocity, double desiredVelocity, double maxVelocity, double acceleration, double decceleration, double gravity, long time) {
		double finalVelocity = getNextVelocity(initalVelocity, desiredVelocity, maxVelocity, acceleration, decceleration, gravity, time);
		return initialPosition + (((finalVelocity + initalVelocity) / 2.0) * getTime(time));
	}
	
	public static double getNextVelocity(double initalVelocity, double desiredVelocity, double maxVelocity, double acceleration, double decceleration, double gravity, long time) {
		double finalVelocity;
		if (Math.abs(maxVelocity) < Math.abs(initalVelocity)) {
			if (initalVelocity < 0.0) {
				finalVelocity = initalVelocity + (decceleration * getTime(time));
			} else if (initalVelocity > 0.0) {
				finalVelocity = initalVelocity + (-1 * (decceleration * getTime(time)));
			} else {
				finalVelocity = initalVelocity;
			}
		} else if ((desiredVelocity == 0.0 && gravity != 0.0) || (acceleration == 0.0 && decceleration == 0.0)) {
			finalVelocity = initalVelocity + (gravity * getTime(time));
		} else {
			if (initalVelocity < 0.0 && desiredVelocity > initalVelocity) {
				finalVelocity = initalVelocity + (decceleration * getTime(time));
			} else if (initalVelocity <= 0.0 && desiredVelocity < initalVelocity) {
				finalVelocity = initalVelocity + (-1 * (acceleration * getTime(time)));
			} else if (initalVelocity > 0.0 && desiredVelocity < initalVelocity) {
				finalVelocity = initalVelocity + (-1 * (decceleration * getTime(time)));
			}  else if (initalVelocity >= 0.0 && desiredVelocity > initalVelocity) {
				finalVelocity = initalVelocity + (acceleration * getTime(time));
			} else {
				finalVelocity = initalVelocity;
			}
			
			// If desired velocity is passed, then use desired velocity
			if ((desiredVelocity > finalVelocity && initalVelocity > desiredVelocity)
					|| (desiredVelocity < finalVelocity && initalVelocity < desiredVelocity)) {
				finalVelocity = desiredVelocity;
			}
		}
		
		// If max velocity is passed, then use max velocity
		if (Math.abs(maxVelocity) < Math.abs(finalVelocity) && Math.abs(initalVelocity) < Math.abs(maxVelocity)) {
			return (finalVelocity < 0.0 ? -1.0 : 1.0) * Math.abs(maxVelocity);
		}
		return finalVelocity;
	}
	
	private static boolean isIntersection(double r1_x_min, double r1_y_min, double r1_x_max, double r1_y_max, double r2_x_min, double r2_y_min, double r2_x_max, double r2_y_max) {
		// New Method (Detects Edge Overlays and Corners
		return (((r1_x_min < r2_x_min && r1_x_max >= r2_x_min)
				|| (r1_x_max > r2_x_max && r1_x_min <= r2_x_max))
				&& ((r1_y_min < r2_y_min && r1_y_max >= r2_y_min)
				|| (r1_y_max > r2_y_max && r1_y_min <= r2_y_max)))
			|| (((r2_y_min <= r1_y_min && r1_y_min <= r2_y_max) 
				|| (r2_y_min <= r1_y_max && r1_y_max <= r2_y_max) 
				|| (r1_y_min <= r2_y_min && r2_y_min <= r1_y_max) 
				|| (r1_y_min <= r2_y_max && r2_y_max <= r1_y_max)) 
				&& (((r2_x_min <= r1_x_min && r1_x_min <= r2_x_max) 
				|| (r2_x_min <= r1_x_max && r1_x_max <= r2_x_max) 
				|| (r1_x_min <= r2_x_min && r2_x_min <= r1_x_max) 
				|| (r1_x_min <= r2_x_max && r2_x_max <= r1_x_max))));
		
		// Broken Method
		/*return Math.abs(r1_x_min - r2_x_min) < (((r1_x_max - r1_x_min) + (r2_x_max - r2_x_min)) / 2.0) 
			&& Math.abs(r1_y_min - r2_y_min) < (((r1_y_max - r1_y_min) + (r2_y_max - r2_y_min)) / 2.0);*/
			
		// Old Method
		/*return (((r2_y_min < r1_y_min && r1_y_min < r2_y_max) 
				|| (r2_y_min < r1_y_max && r1_y_max < r2_y_max) 
				|| (r1_y_min < r2_y_min && r2_y_min < r1_y_max) 
				|| (r1_y_min < r2_y_max && r2_y_max < r1_y_max)) 
				&& (((r2_x_min < r1_x_min && r1_x_min < r2_x_max) 
				|| (r2_x_min < r1_x_max && r1_x_max < r2_x_max) 
				|| (r1_x_min < r2_x_min && r2_x_min < r1_x_max) 
				|| (r1_x_min < r2_x_max && r2_x_max < r1_x_max))));*/
	}
	
	public static boolean isCollision(Rectangle2D r1, Rectangle2D r2) {
		return isIntersection(
				r1.getMinX(), 
				r1.getMinY(), 
				r1.getMaxX(), 
				r1.getMaxY(), 
				r2.getMinX(), 
				r2.getMinY(), 
				r2.getMaxX(), 
				r2.getMaxY()
			);
	}
	
	public static boolean isCollision(Rectangle2D r1_prev, Rectangle2D r1_next, Rectangle2D r2_prev, Rectangle2D r2_next) {
		return isIntersection(
				Math.min(r1_prev.getMinX(), r1_next.getMinX()), 
				Math.min(r1_prev.getMinY(), r1_next.getMinY()),
				Math.max(r1_prev.getMaxX(), r1_next.getMaxX()),
				Math.max(r1_prev.getMaxY(), r1_next.getMaxY()),
				Math.min(r2_prev.getMinX(), r2_next.getMinX()), 
				Math.min(r2_prev.getMinY(), r2_next.getMinY()),
				Math.max(r2_prev.getMaxX(), r2_next.getMaxX()),
				Math.max(r2_prev.getMaxY(), r2_next.getMaxY())
			);
	}
	
	public static boolean isTopPentration(Rectangle2D object, Rectangle2D pentrator) {
		return object.getMinY() < pentrator.getMaxY();
	}
	
	public static boolean isBottomPentration(Rectangle2D object, Rectangle2D pentrator) {
		return isTopPentration(pentrator, object);
	}
	
	public static boolean isLeftPentration(Rectangle2D object, Rectangle2D pentrator) {
		return object.getMinX() < pentrator.getMaxX();
	}
	
	public static boolean isRightPentration(Rectangle2D object, Rectangle2D pentrator) {
		return isLeftPentration(pentrator, object);
	}
	
	//Old Engine
	/*public static double getForce(double mass, double acceleration) {
		return mass * acceleration;
	}
	
	public static double getDragMultiplier(double densityOfMedian, double surfaceArea, double dragCoefficient) {
		return (densityOfMedian * surfaceArea * dragCoefficient) / 2.0;
	}
	
	public static double getDragMultiplier_2(double acceleration, double mass, double terminalVelocity) {
		// Drag Multiplier = (density of median * projected area * drag coefficient) / 2
		// Drag Force = Drag Multiplier * velocity^2
		// Force = Mass * Acceleration
		// Mass * Acceleration = Drag Multiplier * terminalVelocity^2
		// (Mass * Acceleration) / terminalVelocity^2 = Drag Multiplier
		return (acceleration * mass) / (terminalVelocity * terminalVelocity);
	}
	
	public static double getDragForce(double dragMultiplier, double velocity) {
		return dragMultiplier * velocity * velocity;
	}
	
	public static double getNaturalForceY(double mass, double gravity, double angleInDegreesFromXAxis) {
		return mass * Math.abs(gravity) * Math.cos(Math.toRadians(angleInDegreesFromXAxis));
	}
	
	public static double getValue(double valueX, double valueY) {
		return Math.pow((valueX * valueX) + (valueY * valueY), 0.5);
	}
	
	public static double getAngleInDegrees(double valueX, double valueY) {
		return Math.atan(valueY/valueX);
	}
	
	public static double getValueX(double value, double angleInDegreesFromXAxis) {
		return value * Math.cos(Math.toRadians(angleInDegreesFromXAxis));
	}
	
	public static double getValueY(double value, double angleInDegreesFromXAxis) {
		return value * Math.sin(Math.toRadians(angleInDegreesFromXAxis));
	}
	
	public static double getFrictionForce(double frictionCoeffient, double naturalForce) {
		return frictionCoeffient * naturalForce;
	}
	
	public static double getNextPositionX(double initialPosition, double initalVelocity, double acceleration, double frictionForce, double mass, double maxVelocity, long time) {
		double finalVelocity = getNextVelocityX(initalVelocity, acceleration, frictionForce, mass, maxVelocity, time);
		return initialPosition + (finalVelocity < 0.0 ? -1.0 : 1.0) * (((finalVelocity * initalVelocity) / 2.0) * ((double)time / (double)GlobalConstants.NANOSECONDS));
	}
	
	public static double getNextPositionY(double initialPosition, double initalVelocity, double acceleration, double dragForce, double mass, long time) {
		double finalVelocity = getNextVelocityY(initalVelocity, acceleration, dragForce, mass, time);
		return initialPosition + (finalVelocity < 0.0 ? -1.0 : 1.0) * (((finalVelocity * initalVelocity) / 2.0) * ((double)time / (double)GlobalConstants.NANOSECONDS));
	}
	
	public static double getNextVelocityX(double initalVelocity, double acceleration, double frictionForce, double mass, double maxVelocity, long time) {
		double realAcceleration = (acceleration * mass + ((initalVelocity < 0.0 ? 1.0 : -1.0) * Math.abs(frictionForce))) / Math.abs(mass);
		double finalVelocity = initalVelocity + (realAcceleration * ((double)time / (double)GlobalConstants.NANOSECONDS));
		if (Math.abs(acceleration * mass) < Math.abs(frictionForce) && ((finalVelocity <= 0.0 && initalVelocity >= 0.0) || (finalVelocity >= 0.0 && initalVelocity <= 0.0))) {
			return 0.0;
		} else if (Math.abs(maxVelocity) < Math.abs(finalVelocity)) {
			return Math.abs(maxVelocity) * (finalVelocity < 0.0 ? -1.0 : 1.0);
		}
		
		if (finalVelocity != 0.0) {
			return finalVelocity;
		}
		
		return finalVelocity;
	}
	
	public static double getNextVelocityY(double initalVelocity, double acceleration, double dragForce, double mass, long time) {
		double realAcceleration = ((acceleration * mass) - dragForce) / mass;
		return initalVelocity + (realAcceleration * ((double)time / (double)GlobalConstants.NANOSECONDS));
	}*/
}
