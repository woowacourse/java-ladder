package domain;

import domain.util.Display;
import domain.util.Point;
import domain.util.PointGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line implements Display {

	private final static String LADDER_DELIMITER = "|";
	private final static String PREFIX = "     |";
	private final static String SUFFIX = "|";
	private final List<Point> points;

	private Line(List<Point> points) {
		this.points = points;
	}

	public static Line create(LadderWidth ladderWidth, PointGenerator pointGenerator) {
		List<Point> line = new ArrayList<>();
		while (ladderWidth.getWidth() > line.size()) {
			Point point = pointGenerator.generate();
			line.add(point);
			addAbsenceIfPresenceIsAdded(line, point, ladderWidth.getWidth());
		}
		return new Line(line);
	}

	private static void addAbsenceIfPresenceIsAdded(List<Point> line, Point point, int ladderWidth) {
		if (line.size() == ladderWidth) return;
		if (point.isPresent()) {
			line.add(Point.ABSENCE);
		}
	}
	@Override
	public String format() {
		String line = points.stream()
				.map(Point::format)
				.collect(Collectors.joining(LADDER_DELIMITER, PREFIX, SUFFIX));
		return line;
	}
}
