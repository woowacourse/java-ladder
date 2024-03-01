package domain;

import java.util.*;

public class Line {
    private final List<Point> points;

    public Line(final Point... point) {
        final List<Point> points = List.of(point);
        validate(points);
        this.points = points;
    }

    private void validate(final List<Point> points) {
//        validateEmptiness(points);
        validateFirstPoint(points);
    }

    private void validateFirstPoint(final List<Point> points) {
        Point firstPoint = points.get(0);
        if (firstPoint.equals(new Point(true, false))) {
            throw new IllegalArgumentException("첫번째 위치에서 왼쪽으로 연결 될 수 없습니다.");
        }
    }

    private void validateEmptiness(final List<Point> points) {
    }

}
