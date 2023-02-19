package domain;

import java.util.Collections;
import java.util.List;

import domain.util.Point;

public class Line {
	private final List<Point> points;

	public Line(final List<Point> points){
		this.points = points;
	}

	public List<Point> getPoints() {
		return Collections.unmodifiableList(points);
	}
}
