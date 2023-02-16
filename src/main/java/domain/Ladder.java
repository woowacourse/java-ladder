package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import exception.Error;

public class Ladder {
	private final List<Level> levels;

	private Ladder(List<Level> level) {
		this.levels = level;
	}

	public static Ladder from(int height, int participantSize) {
		validate(height);
		return new Ladder(IntStream.range(0, height)
			.mapToObj(o -> new Level(participantSize))
			.collect(Collectors.toList()));
	}

	private static void validate(int height) {
		if (height < 1 || height > 100)
			throw new IllegalArgumentException(Error.HEIGHT_RANGE_FROM_1_TO_100.getMessage());
	}

	public int getHeight() {
		return levels.size();
	}

	public int getColumnSize() {
		return levels.get(0).size();
	}

	public List<Level> getLadder() {
		return levels;
	}
}
