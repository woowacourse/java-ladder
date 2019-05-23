package ladder.domain;

public class Point {
	private boolean leftPosition;
	private boolean currentPosition;

	public Point(boolean leftPosition, boolean currentPosition) {
		if (leftPosition && currentPosition) {
			throw new IllegalArgumentException(ExceptionOutput.VIOLATE_POINTS.getOutputMessage());
		}
		this.leftPosition = leftPosition;
		this.currentPosition = currentPosition;
	}

	public static Point first() {
		return new Point(false, RandomGenerator.getNextValue());
	}

	public static Point last(boolean currentPosition) {
		return new Point(currentPosition, false);
	}

	public Point next() {
		if (this.currentPosition) {
			return new Point(true, false);
		}
		return new Point(false, RandomGenerator.getNextValue());
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
