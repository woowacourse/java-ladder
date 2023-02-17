package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Level {
	private final Random random = new Random();
	private final List<Stool> level;

	public Level(int participantsSize) {
		this.level = initLine(participantsSize);
		makeStools();
	}

	private List<Stool> initLine(int participantSize) {
		return Stream.generate(() -> Stool.EMPTY)
				.limit(participantSize - 1)
				.collect(Collectors.toList());
	}

	private void makeStools() {
		IntStream.range(0, level.size()).forEach(this::makeStool);

		if (isNotValidLevel()) {
			makeStools();
		}
	}

	private void makeStool(int index) {
		if (index == 0 || !isStoolExist(index - 1)) {
			level.set(index, Stool.of(random.nextBoolean()));
		}
	}

	public boolean isStoolExist(int index) {
		return level.get(index).isExist();
	}

	private boolean isNotValidLevel() {
		return countStools() == 0;
	}

	public int countStools() {
		return (int) level.stream()
				.filter(Stool::isExist)
				.count();
	}

	public int size() {
		return level.size();
	}

	public List<Stool> getStools() {
		return new ArrayList<>(level);
	}
}
