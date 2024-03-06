package domain;

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

    public int nextIndex(int index) {
        if (isInValidIndex(index)) {
            throw new IllegalArgumentException("음수이거나 포인트의 개수보다 큰 인덱스는 허용하지 않습니다.");
        }
        if (isConnectedWithNextIndex(index)) {
            return ++index;
        }
        if (isConnectedWithPrevIndex(index)) {
            return --index;
        }
        return index;
    }

    private boolean isConnectedWithPrevIndex(int index) {
        return index > 0 && points.get(index - 1).isConnected();
    }

    private boolean isConnectedWithNextIndex(int index) {
        return index < points.size() && points.get(index).isConnected();
    }

    private boolean isInValidIndex(int index) {
        return index < 0 || index > points.size();
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
