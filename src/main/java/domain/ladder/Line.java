package domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.util.PointGenerator;

public class Line {
	private final List<Point> points;

	public Line(final int width, final PointGenerator pointGenerator) {
		points = new ArrayList<>();
		while (width > points.size()) {
			Point point = pointGenerator.generate();
			points.add(point);
			addAbsenceIfLastlyAddedPresence(width, point);
		}
	}

	private void addAbsenceIfLastlyAddedPresence(final int width, final Point lastlyAdded) {
		if (points.size() == width) {
			return;
		}
		if (lastlyAdded.isPresent()) {
			points.add(Point.ABSENCE);
		}
	}

	public List<Integer> moveThroughLine(final List<Integer> indicies) {
		int size = points.size();
		for (int i = 0; i < size; i++) {
			Point point = points.get(i);
			swapIfPointPresent(indicies, i, point);
		}
		return indicies;
	}

	private void swapIfPointPresent(final List<Integer> indicies, final int i, final Point point) {
		if (point.isPresent()) {
			Collections.swap(indicies, i, i + 1);
		}
	}

	public List<Point> getPoints() {
		return Collections.unmodifiableList(points);
	}
}
