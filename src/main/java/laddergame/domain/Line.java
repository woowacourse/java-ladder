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

        while (lineSize.isBiggerThan(points.size())) {
            points.add(generatePoint(points, pointGenerator));
        }

        return new Line(points);
    }

    private static Point generatePoint(final List<Point> points, final PointGenerator pointGenerator) {
        if (points.isEmpty()) {
            return pointGenerator.generate();
        }

        Point lastPoint = points.get(points.size() - 1);
        if (lastPoint.isExist()) {
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
