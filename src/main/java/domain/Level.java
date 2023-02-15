package domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Level {
	private static final Random random = new Random();

	private final List<Stool> level;

	public Level(int participantsSize) {
		this.level = initLine(participantsSize);
		makeStools();
	}

	public int size() {
		return level.size();
	}

	public boolean isStoolExist(int index) {
		return getStool(index).isStool();
	}

	public int countStools() {
		return (int)level.stream()
			.filter(Stool::isStool)
			.count();
	}

	private List<Stool> initLine(int participantSize) {
		return IntStream.range(0, participantSize - 1)
			.mapToObj(o -> Stool.EMPTY)
			.collect(Collectors.toList());
	}

	private void makeStools() {
		level.set(0, Stool.of(random.nextBoolean()));
		IntStream.range(1, level.size()).forEach(this::makeStool);

		if (isNotValidLevel())
			makeStools();
	}

	private void makeStool(int index) {
		if (getStool(index - 1).isStool())
			return;

		level.set(index, Stool.of(random.nextBoolean()));
	}

	private boolean isNotValidLevel() {
		return (int)level.stream()
			.filter(Stool::isStool)
			.count() == 0;
	}

	private Stool getStool(int index) {
		return level.get(index);
	}
}
