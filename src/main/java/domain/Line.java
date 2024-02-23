package domain;

import java.util.ArrayList;
import java.util.List;
import strategy.PointStrategy;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line of(PointStrategy pointStrategy, int playerCount) {
        List<Point> points = new ArrayList<>();
        points.add(pointStrategy.generatePoint());
        for (int i = 1; i < playerCount - 1; i++) {
            points.add(findNextPoint(points.get(i - 1), pointStrategy));
        }
        return new Line(points);
    }

    private static Point findNextPoint(Point previous, PointStrategy pointStrategy) {
        if (previous.equals(Point.CONNECTED)) {
            return Point.DISCONNECTED;
        }
        return pointStrategy.generatePoint();
    }

    public List<Point> getPoints() {
        return points;
    }
}
