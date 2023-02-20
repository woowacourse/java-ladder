package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    public static final int POINT_MIN_SIZE = 0;
    public static final int POINT_MAX_SIZE = 19;

    private final List<Point> points;

    public Line(final int pointSize) {
        validate(pointSize);
        this.points = generatePoints(pointSize);
    }

    private void validate(final int pointSize) {
        if (pointSize < POINT_MIN_SIZE || pointSize > POINT_MAX_SIZE) {
            throw new IllegalArgumentException("포인트 범위는 0부터 19까지입니다.");
        }
    }

    private List<Point> generatePoints(final int pointSize) {
        List<Point> points = new ArrayList<>();
        for (int pointIndex = 0; pointIndex < pointSize; pointIndex++) {
            Point currentPoint = getCurrentPoint(pointIndex);
            points.add(currentPoint);
        }
        return points;
    }

    private Point getCurrentPoint(int pointIndex) {
        Point currentPoint = Point.choosePoint();
        int previousPointIndex = pointIndex - 1;
        if (previousPointIndex >= 0) {
            currentPoint = Point.choosePoint(points.get(pointIndex - 1));
        }
        return currentPoint;
    }

    public Point getPointAt(final int index) {
        return points.get(index);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

}
