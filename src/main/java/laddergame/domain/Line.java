package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Point> points;

    private Line(final List<Point> points) {
        this.points = points;
    }

    public static Line create(final LineSize lineSize, final PointGenerator pointGenerator) {
        List<Point> points = new ArrayList<>();

        Point temp = Point.EMPTY;

        while (lineSize.isBiggerThan(points.size())) {
            final Point point = generatePoint(temp, pointGenerator);
            points.add(point);
            temp = point;
        }

        return new Line(points);
    }

    private static Point generatePoint(final Point before, final PointGenerator pointGenerator) {
        if (before.isExist()) {
            return Point.EMPTY;
        }

        return pointGenerator.generate();
    }

    public List<Boolean> getPointsState() {
        return points.stream()
                .map(Point::isExist)
                .toList();
    }
}
