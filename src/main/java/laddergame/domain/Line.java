package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private List<Point> line;

	public Line(int width) {
		line = new ArrayList<>();
		for (int i = 0; i < width; i++) {
			line.add(new Point(false));
		}
	}

	public void connect(int column) {
		try {
			checkLeft(column);
		} catch (IndexOutOfBoundsException e) {}
		try {
			checkRight(column);
		} catch (IndexOutOfBoundsException e) {}
		line.set(column, new Point(true));
	}

	private void checkRight(int column) {
		if (line.get(column + 1).booleanValue()) {
			throw new IllegalArgumentException("오른쪽에 중복");
		}
	}

	private void checkLeft(int column) {
		if (line.get(column - 1).booleanValue()) {
			throw new IllegalArgumentException("왼쪽에 중복");
		}
	}

	public boolean isLinked(int column) {
		return line.get(column).booleanValue();
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Point point : line) {
			stringBuilder.append(point);
			stringBuilder.append("|");
		}
		return stringBuilder.toString();
	}
}
