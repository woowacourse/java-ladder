package domain;

import java.util.List;

import domain.util.Point;

public class Line {
	List<Point> points;

	public Line(List<Point> points){
		this.points = points;
	}

	public List<Point> getPoints() {
		return points;
	}
}
