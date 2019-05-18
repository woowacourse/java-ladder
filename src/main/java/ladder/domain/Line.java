package ladder.domain;

import java.util.List;

public class Line {
	private final List<Point> points;

	public Line(List<Point> points) {
		this.points = points;
	}

	public int getNextPosition(int position) {
		return position + points.get(position).move();
	}

	public List<Point> getPoints() {
		return this.points;
	}
}
