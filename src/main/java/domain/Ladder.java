package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
	private final List<List<Boolean>> level;

	public Ladder(int height, int participantSize) {
		validate(height);
		this.level = IntStream.range(0, height)
			.mapToObj(o -> initLine(participantSize))
			.collect(Collectors.toList());
	}

	public int getHeight() {
		return level.size();
	}

	public int getColumnSize() {
		return level.get(0).size();
	}

	private void validate(int height) {
		if (height < 1 || height > 100)
			throw new IllegalArgumentException("높이는 1부터 100까지만 가능합니다");
	}

	private static List<Boolean> initLine(int participantSize) {
		return IntStream.range(0, participantSize - 1)
			.mapToObj(o -> false)
			.collect(Collectors.toList());
	}
}
