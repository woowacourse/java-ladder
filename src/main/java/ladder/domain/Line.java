package ladder.domain;

import java.util.ArrayList;
import java.util.List;

import ladder.generator.PointGenerator;

public class Line {
	private final List<Point> points;

	public Line(List<Point> points) {
		this.points = points;
	}

	public int getNextPosition(int position) {
		return position + points.get(position).move().getDirection();
	}

	public static Line generateLine(int countOfPerson) {
		List<Point> points = new ArrayList<>();

		Point point = PointGenerator.firstPoint();
		points.add(point);
		for (int i = 1; i < countOfPerson - 1; i++) {
			point = PointGenerator.nextPoint(point);
			points.add(point);
		}
		points.add(PointGenerator.lastPoint(point));

		return new Line(points);
	}

	public List<Point> getPoints() {
		return this.points;
	}
}
