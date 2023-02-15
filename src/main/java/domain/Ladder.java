package domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
	private static final Random random = new Random();
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

	public List<List<Boolean>> getLadder() {
		return level;
	}

	public void makeLadder() {
		getLadder().forEach(Ladder::makeStools);
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

	private static void makeStools(List<Boolean> level) {
		level.set(0, random.nextBoolean());
		IntStream.range(1, level.size())
			.forEach(index -> makeStool(level, index));

		if (isNotValidLevel(level))
			makeStools(level);
	}

	private static boolean isNotValidLevel(List<Boolean> level) {
		return (int)level.stream()
			.filter(stool -> stool)
			.count() == 0;
	}

	private static void makeStool(List<Boolean> level, int index) {
		if (level.get(index - 1))
			return;

		level.set(index, random.nextBoolean());
	}
}
