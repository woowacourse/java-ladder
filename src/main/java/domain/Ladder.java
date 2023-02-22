package domain;

import java.util.ArrayList;
import java.util.List;

import exception.Error;

public class Ladder {
	private static final int FIRST_COLUMN = 0;
	private final List<Level> levels;

	private Ladder(List<Level> level) {
		this.levels = level;
	}

	public static Ladder from(int height, int participantSize) {
		validate(height);

		List<Level> levelList = new ArrayList<>();
		for (int i = 0; i < height; i++) {
			levelList.add(new Level(participantSize));
		}
		return new Ladder(levelList);
	}

	private static void validate(int height) {
		if (height < 1 || height > 100) {
			throw new IllegalArgumentException(Error.HEIGHT_RANGE_FROM_1_TO_100.getMessage());
		}
	}

	public int start(int position) {
		for (Level thisLevel : levels) {
			if (position - 1 >= FIRST_COLUMN && thisLevel.isStoolExist(position - 1)) {
				position--;
				continue;
			}
			if (position < thisLevel.size() && thisLevel.isStoolExist(position)) {
				position++;
			}
		}
		return position;
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
