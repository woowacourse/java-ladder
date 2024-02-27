package laddergame.domain.ladder;

import java.util.Collections;
import java.util.List;
import laddergame.exception.LadderGameException;

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
            throw new LadderGameException("[ERROR] 포인트가 겹치는 라인을 생성할 수 없습니다.");
        }
    }

    public Position goHorizontal(final Position position) {
        validatePosition(position);

        if (canGoLeft(position)) {
            return position.decrease();
        }

        if (canGoRight(position)) {
            return position.increase();
        }

        return position;
    }

    private void validatePosition(final Position position) {
        if (position.isGreaterThan(points.size())) {
            throw new LadderGameException("[ERROR] Line 범위 밖의 포지션은 이동할 수 없습니다.");
        }
    }

    private boolean canGoLeft(final Position position) {
        return position.isNot(0) && points.get(position.getPosition() - 1).isExist();
    }

    private boolean canGoRight(final Position position) {
        return position.isNot(points.size()) && points.get(position.getPosition()).isExist();
    }

    public int size() {
        return points.size();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
