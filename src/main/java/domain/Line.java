package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Point> points;

    public Line(BooleanGenerator booleanGenerator, int personCount) {
        points = generatePoints(booleanGenerator, personCount);
    }

    private List<Point> generatePoints(BooleanGenerator booleanGenerator, int personCount) {
        List<Point> points = new ArrayList<>();

        Point previousPoint = Point.DISCONNECTED;
        for (int i = 0; i < personCount - 1; i++) {
            Point currentPoint = generatePoint(booleanGenerator, previousPoint);
            points.add(currentPoint);
            previousPoint = currentPoint;
        }

        return points;
    }

    private Point generatePoint(BooleanGenerator booleanGenerator, Point previousPoint) {
        if (previousPoint.isConnected()) {
            return Point.DISCONNECTED;
        }

        return generatePoint(booleanGenerator);
    }

    private Point generatePoint(BooleanGenerator booleanGenerator) {
        if (booleanGenerator.generate()) {
            return Point.CONNECTED;
        }

        return Point.DISCONNECTED;
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
