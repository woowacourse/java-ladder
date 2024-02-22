package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Point> points;
    
    private Line(final List<Point> points) {
        this.points = points;
    }

    public static Line create(final LineSize lineSize, final BooleanGenerator booleanGenerator) {
        List<Point> points = new ArrayList<>();

        Point temp = Point.EMPTY;

        while (lineSize.isBiggerThan(points.size())) {
            final Point point = generatePoint(temp, booleanGenerator);
            points.add(point);
            temp = point;
        }

        return new Line(points);
    }

    private static Point generatePoint(final Point before, final BooleanGenerator booleanGenerator) {
        if (before.isExist()) {
            return Point.EMPTY;
        }

        return Point.from(booleanGenerator.generate());
    }

    public List<Boolean> getPointsState() {
        return points.stream()
                .map(Point::isExist)
                .toList();
    }
}
