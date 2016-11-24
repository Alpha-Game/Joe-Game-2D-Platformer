package joe.game.platformer.physics;

public enum CollisionType {
	No_Collision,
	No_Edge,
	Top_Edge,
	Top_Bottom_Edge,
	Top_Left_Edge,
	Top_Right_Edge,
	Top_Bottom_Left_Edge,
	Top_Bottom_Right_Edge,
	Top_Left_Right_Edge,
	Top_Bottom_Left_Right_Edge,
	Bottom_Edge,
	Bottom_Left_Edge,
	Bottom_Right_Edge,
	Bottom_Left_Right_Edge,
	Left_Edge,
	Left_Right_Edge,
	Right_Edge;
	
	
	public static CollisionType create(boolean onTopEdge, boolean onBottomEdge, boolean onLeftEdge, boolean onRightEdge) {
		if (onTopEdge) {
			if (onBottomEdge) {
				if (onLeftEdge) {
					if (onRightEdge) {
						return Top_Bottom_Left_Right_Edge;
					} else {
						return Top_Bottom_Left_Edge;
					}
				} else if (onRightEdge) {
					return Top_Bottom_Right_Edge;
				} else {
					return Top_Bottom_Edge;
				}
			} else if (onLeftEdge) {
				if (onRightEdge) {
					return Top_Left_Right_Edge;
				} else {
					return Top_Left_Edge;
				}
			} else if (onRightEdge) {
				return Top_Right_Edge;
			} else {
				return Top_Edge;
			}
		} else if (onBottomEdge) {
			if (onLeftEdge) {
				if (onRightEdge) {
					return Bottom_Left_Right_Edge;
				} else {
					return Bottom_Left_Edge;
				}
			} else if (onRightEdge) {
				return Bottom_Right_Edge;
			} else {
				return Bottom_Edge;
			}
		} else if (onLeftEdge) {
			if (onRightEdge) {
				return Left_Right_Edge;
			} else {
				return Left_Edge;
			}
		} else if (onRightEdge) {
			return Right_Edge;
		} else {
			return No_Edge;
		}
	}
	
	public boolean isCollision() {
		return !this.equals(No_Collision);
	}
	
	public boolean isTop() {
		return this.equals(Top_Edge) 
				|| this.equals(Top_Bottom_Edge) || this.equals(Top_Left_Edge) || this.equals(Top_Right_Edge) 
				|| this.equals(Top_Bottom_Left_Edge) || this.equals(Top_Bottom_Right_Edge) || this.equals(Top_Left_Right_Edge) 
				|| this.equals(Top_Bottom_Left_Right_Edge);
	}
	
	public boolean isBottom() {
		return this.equals(Bottom_Edge) 
				|| this.equals(Top_Bottom_Edge) || this.equals(Bottom_Left_Edge) || this.equals(Bottom_Right_Edge) 
				|| this.equals(Top_Bottom_Left_Edge) || this.equals(Top_Bottom_Right_Edge) || this.equals(Bottom_Left_Right_Edge) 
				|| this.equals(Top_Bottom_Left_Right_Edge);
	}
	
	public boolean isLeft() {
		return this.equals(Left_Edge) 
				|| this.equals(Top_Left_Edge) || this.equals(Bottom_Left_Edge) || this.equals(Left_Right_Edge)
				|| this.equals(Top_Bottom_Left_Edge) || this.equals(Top_Left_Right_Edge) || this.equals(Bottom_Left_Right_Edge) 
				|| this.equals(Top_Bottom_Left_Right_Edge);
	}
	
	public boolean isRight() {
		return this.equals(Right_Edge) 
				|| this.equals(Top_Right_Edge) || this.equals(Bottom_Right_Edge) || this.equals(Left_Right_Edge)
				|| this.equals(Top_Bottom_Right_Edge) || this.equals(Top_Left_Right_Edge) || this.equals(Bottom_Left_Right_Edge) 
				|| this.equals(Top_Bottom_Left_Right_Edge);
	}
}
