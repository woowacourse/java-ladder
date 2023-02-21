package domain;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {

    private final BooleanGenerator booleanGenerator;

    public LineGenerator(BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    public Line generateLine(int personCount) {
        return new Line(generatePoints(personCount - 1));
    }

    private List<Point> generatePoints(int number) {
        List<Point> points = new ArrayList<>();

        Point previousPoint = Point.DISCONNECTED;
        for (int i = 0; i < number; i++) {
            Point currentPoint = generatePoint(previousPoint);
            points.add(currentPoint);
            previousPoint = currentPoint;
        }

        return points;
    }

    private Point generatePoint(Point previousPoint) {
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
