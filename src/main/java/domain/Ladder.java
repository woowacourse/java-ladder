package domain;

import exception.Error;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Ladder {
	private static final int MIN_HEIGHT = 1;
	private static final int MAX_HEIGHT = 100;

	private final List<Level> levels;

	private Ladder(List<Level> level) {
		this.levels = level;
	}

	public static Ladder from(int height, int participantSize) {
		validate(height);

		return Stream.generate(() -> new Level(participantSize))
				.limit(height)
				.collect(collectingAndThen(toList(), Ladder::new));
	}

	private static void validate(int height) {
		if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
			throw new IllegalArgumentException(Error.HEIGHT_RANGE_FROM_1_TO_100.getMessage());
		}
	}

	public int getHeight() {
		return levels.size();
	}

	public int getColumnSize() {
		return levels.get(0).size();
	}

	public List<Level> getLevels() {
		return levels;
	}
}
