package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
	private List<Line> ladder;

	public Ladder(int height, int width) {
		ladder = new ArrayList<>();
		for (int i = 0; i <= height; i++) {
			ladder.add(new Line(width));
		}
		System.out.println("초기상태: \n" + ladder.toString().replace("},", "\n"));
	}

	public void connect(int row, int column) {
		try {
			ladder.get(row).connect(column);
		} catch (IndexOutOfBoundsException e) {
			throw new IllegalArgumentException("추가할 수 없습니다");
		}
		System.out.println("추가상태: \n" + ladder.toString().replace("},", "\n"));
	}

	public boolean isLinked(int row, int column) {
		try {
			return ladder.get(row).isLinked(column);
		} catch (IndexOutOfBoundsException e) {
			throw new IllegalArgumentException("링크가 없음");
		}
	}
}
