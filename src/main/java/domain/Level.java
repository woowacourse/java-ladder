package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Level {
	private static final Random random = new Random();
	public static final int PREVIOUS_STOOL = 1;

	private final List<Stool> level;

	public Level(int playerSize) {
		level = initLine(playerSize);
		makeStools();
	}

	private List<Stool> initLine(int playerSize) {
		List<Stool> stoolList = new ArrayList<>();
		for (int i = 0; i < playerSize - 1; i++) {
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

	private void makeStool(int now) {
		if (getStool(now - PREVIOUS_STOOL).isStool()) {
			return;
		}
		level.set(now, Stool.of(random.nextBoolean()));
	}

	private boolean isNotValidLevel() {
		return (int)level.stream()
			.filter(Stool::isStool)
			.count() == 0;
	}

	public List<Stool> getStools() {
		return new ArrayList<>(level);
	}

	private Stool getStool(int index) {
		return level.get(index);
	}

	public boolean isStoolExist(int index) {
		return getStool(index).isStool();
	}

	public int countStools() {
		return (int)level.stream()
			.filter(Stool::isStool)
			.count();
	}

	public int size() {
		return level.size();
	}
}
