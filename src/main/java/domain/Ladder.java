package domain;

import java.util.ArrayList;
import java.util.List;

import exception.Error;

public class Ladder {
	private static final int FIRST_COLUMN = 0;
	public static final int MIN_HEIGHT = 1;
	public static final int MAX_HEIGHT = 100;

	private final List<Level> levels;

	private Ladder(List<Level> levels) {
		this.levels = levels;
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
		if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
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
