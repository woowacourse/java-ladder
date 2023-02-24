package domain.ladder;

import java.util.Collections;
import java.util.List;

import domain.util.LinePointsGenerator;
import domain.util.Point;

public class Line {
	private final List<Point> points;

	public Line(final LinePointsGenerator linePointsGenerator) {
		this.points = linePointsGenerator.generateLine();
	}

	public int size() {
		return points.size();
	}

	public List<Point> getPoints() {
		return Collections.unmodifiableList(points);
	}

	public void moveOnce(final List<Integer> indicies) {
		int size = points.size();
		for (int i = 0; i < size; i++) {
			Point point = points.get(i);
			swapIfPointPresent(indicies, i, point);
		}
	}

	private void swapIfPointPresent(final List<Integer> indicies, final int i, final Point point) {
		if (point.isPresent()) {
			Collections.swap(indicies, i, i + 1);
		}
	}
}
