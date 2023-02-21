package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Level {
	private static final Random random = new Random();

	private final List<Stool> level;

	public Level(int participantsSize) {
		level = initLine(participantsSize);
		makeStools();
	}

	private List<Stool> initLine(int participantSize) {
		List<Stool> stoolList = new ArrayList<>();
		for (int i = 0; i < participantSize - 1; i++) {
			stoolList.add(Stool.EMPTY);
		}
		return stoolList;
	}

	private void makeStools() {
		level.set(0, Stool.of(random.nextBoolean()));
		for (int i = 1; i < level.size(); i++) {
			makeStool(i);
		}

		if (isNotValidLevel())
			makeStools();
	}

	private boolean isNotValidLevel() {
		return (int)level.stream()
			.filter(Stool::isStool)
			.count() == 0;
	}

	private void makeStool(int index) {
		if (getStool(index - 1).isStool())
			return;

		level.set(index, Stool.of(random.nextBoolean()));
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

	public List<Stool> getStools() {
		return new ArrayList<>(level);
	}

	private Stool getStool(int index) {
		return level.get(index);
	}
}
