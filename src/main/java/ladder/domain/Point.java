package ladder.domain;

public class Point {
	private static final Point LEFT_POSITION = new Point(true, false);
	private static final Point RIGHT_POSITION = new Point(false, true);
	private static final Point STOP_POSITION = new Point(false, false);

	private boolean leftPosition;
	private boolean currentPosition;

	private Point(boolean leftPosition, boolean currentPosition) {
		this.leftPosition = leftPosition;
		this.currentPosition = currentPosition;
	}

	public static Point first() {
		return (RandomGenerator.getNextValue()) ? RIGHT_POSITION : STOP_POSITION;
	}

	public Point last() {
		return valueOf(this.currentPosition, false);
	}

	public Point next() {
		if (this.currentPosition) {
			return LEFT_POSITION;
		}

		return valueOf(false, RandomGenerator.getNextValue());
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

	public Point valueOf(boolean leftPosition, boolean currentPosition) {
		if (leftPosition && currentPosition) {
			throw new IllegalArgumentException(ExceptionOutput.VIOLATE_POINTS.getOutputMessage());
		}

		return (leftPosition) ? LEFT_POSITION : (currentPosition) ? RIGHT_POSITION : STOP_POSITION;
	}
}
