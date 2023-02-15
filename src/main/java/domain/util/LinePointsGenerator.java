package domain.util;

import java.util.ArrayList;
import java.util.List;

public class LinePointsGenerator {
	private final int width;
	private final PointGenerator pointGenerator;

	public LinePointsGenerator(int width, PointGenerator pointGenerator) {
		this.width = width;
		this.pointGenerator = pointGenerator;
	}
	public List<Point> generateLine() {
		List<Point> line = new ArrayList<>();
		while (this.width > line.size()) {
			Point point = pointGenerator.generate();
			line.add(point);
			addAbsenceIfPresenceIsAdded(line, point);
		}
		return line;
	}

	private void addAbsenceIfPresenceIsAdded(List<Point> line, Point point) {
		if (line.size() == this.width) return;
		if (point.isPresent()) {
			line.add(Point.ABSENCE);
		}
	}

}
