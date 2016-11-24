package joe.game.platformer.physics;

public class PhysicalObject {
	public Double x;
	public Double y;
	public Double width;
	public Double height;
	public Double velocity_x;
	public Double velocity_y;
	public Double velocity_x_max;
	public Double velocity_y_max;
	public Double velocity_x_desired;
	public Double velocity_y_desired;
	public Double acceleration_x;
	public Double acceleration_y;
	public Double decceleration_x;
	public Double decceleration_y;
	public Double gravity_x;
	public Double gravity_y;
	public Double mass;
	
	protected PhysicalObject() {}
	
	public PhysicalObject(Double x, Double y, Double width, Double height, Double velocity_x, Double velocity_y, Double velocity_x_max, Double velocity_y_max, Double velocity_x_desired, Double velocity_y_desired, Double acceleration_x, Double acceleration_y, Double decceleration_x, Double decceleration_y, Double gravity_x, Double gravity_y, Double mass) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.velocity_x = velocity_x;
		this.velocity_y = velocity_y;
		this.velocity_x_max = velocity_x_max;
		this.velocity_y_max = velocity_y_max;
		this.velocity_x_desired = velocity_x_desired;
		this.velocity_y_desired = velocity_y_desired;
		this.acceleration_x = acceleration_x;
		this.acceleration_y = acceleration_y;
		this.decceleration_x = decceleration_x;
		this.decceleration_y = decceleration_y;
		this.gravity_x = gravity_x;
		this.gravity_y = gravity_y;
		this.mass = mass;
	}
	
	protected PhysicalObject create(Double x, Double y, Double width, Double height, Double velocity_x, Double velocity_y, Double velocity_x_max, Double velocity_y_max, Double velocity_x_desired, Double velocity_y_desired, Double acceleration_x, Double acceleration_y, Double decceleration_x, Double decceleration_y, Double gravity_x, Double gravity_y, Double mass) {
		return new PhysicalObject(
				x,
				y,
				width,
				height,
				velocity_x,
				velocity_y,
				velocity_x_max,
				velocity_y_max,
				velocity_x_desired,
				velocity_y_desired,
				acceleration_x,
				acceleration_y,
				decceleration_x,
				decceleration_y,
				gravity_x,
				gravity_y,
				mass
		);
	}
	
	public PhysicalObject clone() {
		return create(
				x,
				y,
				width,
				height,
				velocity_x,
				velocity_y,
				velocity_x_max,
				velocity_y_max,
				velocity_x_desired,
				velocity_y_desired,
				acceleration_x,
				acceleration_y,
				decceleration_x,
				decceleration_y,
				gravity_x,
				gravity_y,
				mass
		);
	}
	
	protected PhysicalObject getNextState(long time, Double x, Double y, Double width, Double height, Double velocity_x, Double velocity_y, Double velocity_x_max, Double velocity_y_max, Double velocity_x_desired, Double velocity_y_desired, Double acceleration_x, Double acceleration_y, Double decceleration_x, Double decceleration_y, Double gravity_x, Double gravity_y, Double mass) {

		x = PhysicsCalculator.getNextPosition(x, velocity_x, velocity_x_desired, velocity_x_max, acceleration_x, decceleration_x, gravity_x, time);
		y = PhysicsCalculator.getNextPosition(y, velocity_y, velocity_y_desired, velocity_y_max, acceleration_y, decceleration_y, gravity_y, time);
		velocity_x = PhysicsCalculator.getNextVelocity(velocity_x, velocity_x_desired, velocity_x_max, acceleration_x, decceleration_x, gravity_x, time);
		velocity_y = PhysicsCalculator.getNextVelocity(velocity_y, velocity_y_desired, velocity_y_max, acceleration_y, decceleration_y, gravity_y, time);
		return create(
				x,
				y,
				width,
				height,
				velocity_x,
				velocity_y,
				velocity_x_max,
				velocity_y_max,
				velocity_x_desired,
				velocity_y_desired,
				acceleration_x,
				acceleration_y,
				decceleration_x,
				decceleration_y,
				gravity_x,
				gravity_y,
				mass
		);
	}
	
	public PhysicalObject getNextState(long time) {
		double x = this.x == null ? 0.0 : this.x;
		double y = this.y == null ? 0.0 : this.y;
		double velocity_x = this.velocity_x == null ? 0.0 : this.velocity_x;
		double velocity_y = this.velocity_y == null ? 0.0 : this.velocity_y;
		double velocity_x_max = this.velocity_x_max == null ? 1.0 : this.velocity_x_max;
		double velocity_y_max = this.velocity_y_max == null ? 1.0 : this.velocity_y_max;
		double velocity_x_desired = this.velocity_x_desired == null ? 0.0 : this.velocity_x_desired;
		double velocity_y_desired = this.velocity_x_desired == null ? 0.0 : this.velocity_y_desired;
		double acceleration_x = this.acceleration_x == null ? 0.0 : this.acceleration_x;
		double acceleration_y = this.acceleration_y == null ? 0.0 : this.acceleration_y;
		double decceleration_x = this.decceleration_x == null ? 0.0 : this.decceleration_x;
		double decceleration_y = this.decceleration_y == null ? 0.0 : this.decceleration_y;
		
		return getNextState(
				time, 
				x,
				y,
				width,
				height,
				velocity_x,
				velocity_y,
				velocity_x_max,
				velocity_y_max,
				velocity_x_desired,
				velocity_y_desired,
				acceleration_x,
				acceleration_y,
				decceleration_x,
				decceleration_y,
				gravity_x,
				gravity_y,
				mass
		);
	}
}
