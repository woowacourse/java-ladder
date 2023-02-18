package domain;

import domain.validator.LineValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Point> points;

    public Line(final int pointSize) {
        LineValidator.validate(pointSize);
        this.points = generatePoints(pointSize);
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
        Point currentPoint = Point.generate();
        int previousPointIndex = pointIndex - 1;
        if (previousPointIndex >= 0) {
            currentPoint = Point.generate(points.get(pointIndex - 1));
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
