package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
	private static final int FIRST_COLUMN = 0;

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
		int MIN_HEIGHT = 1;
		int MAX_HEIGHT = 1;

		if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
			throw new IllegalArgumentException(String.format("높이는 %d부터 %d까지만 가능합니다", MIN_HEIGHT, MAX_HEIGHT));
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
