package domain.ladder;

import java.util.Collections;
import java.util.List;

import domain.util.Point;

public class Line {
	private final List<Point> points;

	public Line(final List<Point> points) {
		this.points = points;
	}

	public int size() {
		return points.size();
	}

	public List<Point> getPoints() {
		return Collections.unmodifiableList(points);
	}
}
