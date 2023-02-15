package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public void validateLine() {
        Point state = Point.EMPTY_POINT;
        for (Point line : points) {
            state = comparePastPointAndPresentPoint(state, line);
        }
    }

    private Point comparePastPointAndPresentPoint(Point pastPoint, Point point) {
        if (point.isLink() && pastPoint.isLink()) {
            throw new IllegalArgumentException();
        }
        pastPoint = point;
        return pastPoint;
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }
}
