package domain;

import java.util.List;

import domain.util.LinePointsGenerator;
import domain.util.Point;

public class Line {
	List<Point> points;

	public Line(LinePointsGenerator linePointsGenerator){
		points = linePointsGenerator.generateLine();
	}

	public List<Point> getPoints() {
		return points;
	}
}
