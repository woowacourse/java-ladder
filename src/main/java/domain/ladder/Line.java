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
}
