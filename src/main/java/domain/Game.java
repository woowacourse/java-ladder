package domain;

import java.util.HashMap;
import java.util.Map;

public class Game {
	private static final Map<String, String> resultMap = new HashMap<>();
	private static final int FIRST_COLUMN = 0;

	public static int start(int position, Ladder ladder) {
		for (int i = 0; i < ladder.getHeight(); i++) {
			Level thisLevel = ladder.getLadder().get(i);
			if (position - 1 >= FIRST_COLUMN && thisLevel.isStoolExist(position - 1)) {
				position--;
				continue;
			}
			if (position < ladder.getColumnSize() && thisLevel.isStoolExist(position)) {
				position++;
			}
		}
		return position;
	}
}
