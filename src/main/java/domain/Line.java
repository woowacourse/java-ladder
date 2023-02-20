package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final BooleanGenerator booleanGenerator;
    private final List<Point> points;

    public Line(BooleanGenerator booleanGenerator, int personCount) {
        this.booleanGenerator = booleanGenerator;
        points = generatePoints(personCount);
    }

    private List<Point> generatePoints(int personCount) {
        List<Point> points = new ArrayList<>();

        Point previousPoint = Point.SEPARATION;
        for (int i = 0; i < personCount - 1; i++) {
            Point currentPoint = generatePoint(previousPoint);
            points.add(currentPoint);
            previousPoint = currentPoint;
        }

        return points;
    }

    private Point generatePoint(Point previousPoint) {
        if (previousPoint.isConnection()) {
            return Point.SEPARATION;
        }

        return generatePoint();
    }

    private Point generatePoint() {
        if (booleanGenerator.generate()) {
            return Point.CONNECTION;
        }

        return Point.SEPARATION;
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
