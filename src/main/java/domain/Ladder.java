package domain;

import domain.util.Point;
import domain.util.PointGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

	private final List<Line> lines;

	private Ladder(List<Line> lines) {
		this.lines = lines;
	}

	public static Ladder build(LadderHeight ladderHeight, LadderWidth ladderWidth, PointGenerator pointGenerator) {
		List<Line> lines = new ArrayList<>();
		int height = ladderHeight.getHeight();
		for (int i = 0; i < height; i++) {
			Line line = Line.create(ladderWidth, pointGenerator);
			lines.add(line);
		}
		return new Ladder(lines);
	}

	public List<List<Point>> getLadderPoints() {
		List<List<Point>> points = new ArrayList<>();
		for (Line line : lines) {
			points.add(line.getPoints());
		}
		return points;
	}
}
