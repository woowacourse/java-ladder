package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private final List<Point> points;

	public Line(List<Point> points) {
		this.points = points;
	}

	public int getNextPosition(int position) {
		return position + Direction.valueOf(points.get(position).move());
	}

	public static Line generateLine(int countOfPerson) {
		List<Point> points = new ArrayList<>();

		Point point = Point.first();
		points.add(point);
		for (int i = 1; i < countOfPerson - 1; i++) {
			point = point.next();
			points.add(point);
		}
		points.add(Point.last(points.get(countOfPerson - 2).canGoRight()));

		return new Line(points);
	}

	public List<Point> getPoints() {
		return this.points;
	}
}
