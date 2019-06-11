package ladder.domain;

public class Point {
	public static final Point LEFT_POSITION = new Point(true, false);
	public static final Point RIGHT_POSITION = new Point(false, true);
	public static final Point STOP_POSITION = new Point(false, false);

	private boolean leftPosition;
	private boolean currentPosition;

	private Point(boolean leftPosition, boolean currentPosition) {
		this.leftPosition = leftPosition;
		this.currentPosition = currentPosition;
	}

	public boolean canGoRight() {
		return this.currentPosition;
	}

	public boolean canGoLeft() {
		return this.leftPosition;
	}

	public Direction move() {
		if (leftPosition) {
			return Direction.LEFT;
		}

		if (currentPosition) {
			return Direction.RIGHT;
		}

		return Direction.STOP;
	}
}
