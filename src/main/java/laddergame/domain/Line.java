package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import laddergame.exception.LineOverlappedException;

public class Line {

    private final List<Point> points;

    public Line(final List<Point> points) {
        validateOverlapped(points);
        this.points = points;
    }

    private void validateOverlapped(final List<Point> points) {
        final int size = points.size();

        for (int i = 1; i < size; i++) {
            validatePoint(points.get(i - 1), points.get(i));
        }
    }

    private void validatePoint(final Point before, final Point now) {
        if (before.isExist() && now.isExist()) {
            throw new LineOverlappedException("[ERROR] 포인트가 겹치는 라인을 생성할 수 없습니다.");
        }
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
