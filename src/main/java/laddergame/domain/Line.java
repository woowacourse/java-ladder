package laddergame.domain;

import java.util.List;
import laddergame.exception.LineOverlappedException;

public class Line {

    private final List<Point> points;

    public Line(final List<Point> points) {
        validatePoints(points);
        this.points = points;
    }

    private void validatePoints(final List<Point> points) {
        final int size = points.size();

        if (size == 0 || size == 1) {
            return;
        }

        validateOverlapped(points, size);
    }

    private void validateOverlapped(final List<Point> points, final int size) {
        for (int i = 1; i < size; i++) {
            validatePoint(points.get(i - 1), points.get(i));
        }
    }

    private void validatePoint(final Point before, final Point now) {
        if (before.isExist() && now.isExist()) {
            throw new LineOverlappedException("[ERROR] 포인트가 겹치는 라인을 생성할 수 없습니다.");
        }
    }

    public List<Boolean> getPointsState() {
        return points.stream()
                .map(Point::isExist)
                .toList();
    }

    public int size() {
        return points.size();
    }
}
