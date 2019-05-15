package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private List<Boolean> line;

	public Line(int width) {
		line = new ArrayList<>();
		for (int i = 0; i < width; i++) {
			line.add(false);
		}
	}

	public void connect(int column) {
		try {
			checkLeft(column);
		} catch (IndexOutOfBoundsException e) {}
		try {
			checkRight(column);
		} catch (IndexOutOfBoundsException e) {}
		line.set(column, true);
	}

	private void checkRight(int column) {
		if (line.get(column + 1)) {
			throw new IllegalArgumentException("오른쪽에 중복");
		}
	}

	private void checkLeft(int column) {
		if (line.get(column - 1)) {
			throw new IllegalArgumentException("왼쪽에 중복");
		}
	}

	public boolean isLinked(int column) {
		return line.get(column).booleanValue();
	}

	@Override
	public String toString() {
		return "Line{" +
				"line=" + line +
				'}';
	}
}
