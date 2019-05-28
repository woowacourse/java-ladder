package laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private final List<Point> points;

	public Line(final int width) {
		points = new ArrayList<>();
		for (int i = 0; i < width; i++) {
			points.add(Point.DISCONNECT);
		}
	}

	public boolean connect(final int column) {
		if (!checkRight(column) && !checkLeft(column)) {
			points.set(column, Point.CONNECT);
			return true;
		}
		return false;
	}

	private boolean checkRight(final int column) {
		try {
			return (points.get(column + 1).hasBridge());
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	private boolean checkLeft(final int column) {
		try {
			return (points.get(column - 1).hasBridge());
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public Direction findPosition(final int startPosition) {
		if (checkLeft(startPosition)) {
			return Direction.left();
		}
		if (checkRight(startPosition - 1)) {
			return Direction.right();
		}
		return Direction.keep();
	}

	public List<Point> getLineFormat() {
		return new ArrayList<>(points);
	}

	public int getWidth() {
		return (points.size() - 1);
	}
}
