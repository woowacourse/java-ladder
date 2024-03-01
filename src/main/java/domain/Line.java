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
        validateLastPoint(points);
    }

    private void validateFirstPoint(final List<Point> points) {
        final Point firstPoint = points.get(0);
        if (firstPoint.equals(new Point(true, false))) {
            throw new IllegalArgumentException("첫번째 위치에서 왼쪽으로 연결 될 수 없습니다.");
        }
    }

    private void validateLastPoint(final List<Point> points) {
        final Point lastPoint = points.get(points.size() - 1);
        if (lastPoint.equals(new Point(false, true))) {
            throw new IllegalArgumentException("마지막 위치에서 오른쪽으로 연결 될 수 없습니다.");
        }

    }

    private void validateEmptiness(final List<Point> points) {
    }

    public List<Point> getPoints() {
        return points;
    }
}
