package domain;

import java.util.ArrayList;
import java.util.List;

import exception.Error;

public class Ladder {
	private final List<Level> levels;

	private Ladder(List<Level> level) {
		this.levels = level;
	}

	public static Ladder from(int height, int participantSize) {
		validate(height);

		List<Level> levelList = new ArrayList<>();
		for (int i = 0; i < height; i++) { //  높이만큼 돌면서
			levelList.add(new Level(participantSize)); // 한 행을 만들어줄거임. level이 한 행
		}
		return new Ladder(levelList); // 모든 높이의 발판 정보가 들어있는 levelList를 Ladder의 생성자 파라미터로 보내줄거다.
	}

	private static void validate(int height) {
		if (height < 1 || height > 100) {
			throw new IllegalArgumentException(Error.HEIGHT_RANGE_FROM_1_TO_100.getMessage());
		}
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
