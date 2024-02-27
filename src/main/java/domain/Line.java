package domain;

import java.util.List;
import java.util.stream.Stream;
import strategy.PointStrategy;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line of(PointStrategy pointStrategy, int playerCount) {
        List<Point> points = Stream.iterate(
                pointStrategy.generatePoint(), previous -> findNextPoint(previous, pointStrategy))
            .limit(playerCount - 1)
            .toList();
        return new Line(points);
    }

    public int findNextIndex(int previousIndex) {
        if (previousIndex < points.size() && points.get(previousIndex) == Point.CONNECTED) {
            return previousIndex + 1;
        }
        if (previousIndex > 0 && points.get(previousIndex - 1) == Point.CONNECTED) {
            return previousIndex - 1;
        }
        return previousIndex;
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
