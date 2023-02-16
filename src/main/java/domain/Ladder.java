package domain;

import java.util.ArrayList;
import java.util.List;

import domain.util.Point;

public class Ladder {

	List<Line> lines;

	public Ladder(List<Line> lines) {
		this.lines = lines;
	}

	public List<List<Point>> getLadderPoints() {
		List<List<Point>> points = new ArrayList<>();
		for (Line line : lines) {
			points.add(line.getPoints());
		}
		return points;
	}
}
