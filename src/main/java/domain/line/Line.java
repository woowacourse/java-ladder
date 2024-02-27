package domain.line;

import domain.Direction;

import java.util.Collections;
import java.util.List;

public class Line {
    private static final int NOT_FOUND = -1;
    private static final Point CONNECTED_POINT = Point.CONNECTED;

    private final List<Point> points;

    public Line(List<Point> points) {
        validateNoDuplicatePoints(points);
        this.points = points;
    }

    public Direction nextPosition(int position) {
        if (position < points.size() && points.get(position).isConnected()) {
            return Direction.RIGHT;
        }
        if (position > 0 && points.get(position - 1).isConnected()) {
            return Direction.LEFT;
        }
        return Direction.DOWN;
    }

    private void validateNoDuplicatePoints(List<Point> points) {
        if (hasDuplicatedPoints(points)) {
            throw new IllegalStateException("사다리가 겹치는 라인이 생성되었습니다.");
        }
    }

    private boolean hasDuplicatedPoints(List<Point> points) {
        int indexOfSubList = Collections.indexOfSubList(points, List.of(CONNECTED_POINT, CONNECTED_POINT));
        return indexOfSubList != NOT_FOUND;
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
