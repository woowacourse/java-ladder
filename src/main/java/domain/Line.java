package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> line;

    public Line(final List<Point> points) {
        validateLine(points);
        this.line = points;
    }

    public List<Point> getLine() {
        return new ArrayList<>(line);
    }

    private void validateLine(final List<Point> line) {
        Point state = Point.EMPTY_POINT;
        for (final Point point : line) {
            state = comparePastPointAndPresentPoint(state, point);
        }
    }

    private Point comparePastPointAndPresentPoint(Point pastPoint, final Point point) {
        if (point.isLink() && pastPoint.isLink()) {
            throw new IllegalArgumentException();
        }
        pastPoint = point;
        return pastPoint;
    }
}
