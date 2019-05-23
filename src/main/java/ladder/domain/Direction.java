package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Direction {
	LEFT(-1),
	RIGHT(1),
	STOP(0);

	private int direction;

	Direction(final int direction) {
		this.direction = direction;
	}

	public static int valueOf(Direction direction) {
		List<Direction> directions = Arrays.stream(Direction.values())
				.filter(d -> d == direction)
				.collect(Collectors.toList());

		if (directions.isEmpty()) {
			throw new IllegalArgumentException("No found direction");
		}

		return directions.get(0).direction;
	}
}
