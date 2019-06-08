package ladder.generator;

import ladder.domain.ExceptionOutput;
import ladder.domain.Point;

public class PointGenerator {
	public static Point firstPoint() {
		return valueOf(false, RandomGenerator.getNextValue());
	}

	public static Point lastPoint(Point point) {
		return valueOf(point.canGoRight(), false);
	}

	public static Point nextPoint(Point point) {
		if (point.canGoRight()) {
			return Point.LEFT_POSITION;
		}
		return valueOf(false, RandomGenerator.getNextValue());
	}

	private static Point valueOf(boolean leftPosition, boolean currentPosition) {
		if (leftPosition && currentPosition) {
			throw new IllegalArgumentException(ExceptionOutput.VIOLATE_POINTS.getOutputMessage());
		}
		return (leftPosition) ? Point.LEFT_POSITION : (currentPosition) ? Point.RIGHT_POSITION : Point.STOP_POSITION;
	}
}
