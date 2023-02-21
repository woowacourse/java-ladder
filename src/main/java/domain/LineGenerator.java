package domain;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {

    private static final int DELTA = 1;

    private final BooleanGenerator booleanGenerator;

    public LineGenerator(final BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    public Line generateLine(final int personCount) {
        List<Point> points = generatePoints(personCount - DELTA);
        return new Line(points);
    }

    private List<Point> generatePoints(final int number) {
        List<Point> points = new ArrayList<>();

        Point previousPoint = Point.DISCONNECTED;
        for (int i = 0; i < number; i++) {
            Point currentPoint = generatePoint(previousPoint);
            points.add(currentPoint);
            previousPoint = currentPoint;
        }

        return points;
    }

    private Point generatePoint(final Point previousPoint) {
        if (previousPoint.isConnected()) {
            return Point.DISCONNECTED;
        }

        return generatePoint();
    }

    private Point generatePoint() {
        if (booleanGenerator.generate()) {
            return Point.CONNECTED;
        }

        return Point.DISCONNECTED;
    }
}
