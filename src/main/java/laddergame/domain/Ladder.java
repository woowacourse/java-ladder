package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
	private final int height;
	private final int width;
	private List<Line> ladder;

	public Ladder(int height, int width) {
		this.height = height;
		this.width = width;
		ladder = new ArrayList<>();
		for (int i = 0; i <= height; i++) {
			ladder.add(new Line(width));
		}
		// System.out.println("초기상태: \n" + ladder.toString().replace("},", "\n"));
	}

	public void initialize(int count) {
		for (int i = 0; i < count; i++) {
			int randomRow = new Random().nextInt(height) + 1;
			int randomCol = (int) (Math.random() * (width - 1)) + 1;
			connect(randomRow, randomCol);
		}
	}

	public void connect(int row, int column) {
		try {
			ladder.get(row).connect(column);
		} catch (IndexOutOfBoundsException e) {
			throw new IllegalArgumentException("추가할 수 없습니다");
		} catch (IllegalArgumentException e) {

		}
		// System.out.println("추가상태: \n" + ladder.toString().replace("},", "\n"));
	}

	public boolean isLinked(int row, int column) {
		try {
			return ladder.get(row).isLinked(column);
		} catch (IndexOutOfBoundsException e) {
			throw new IllegalArgumentException("링크가 없음");
		}
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Line line : ladder.subList(1, ladder.size())) {
			stringBuilder.append(line);
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
}
