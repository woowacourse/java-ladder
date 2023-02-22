package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Floor {

    private static final int SECOND_INDEX_OF_FLOOR = 1;

    private final List<Point> points;

    public Floor(List<Point> values) {

        List<Point> points = new ArrayList<>(values);

        removeContinuousLine(points);

        this.points = points;
    }

    private void removeContinuousLine(List<Point> points) {
        for (int i = SECOND_INDEX_OF_FLOOR; i < points.size(); i++) {
            checkPreviousPoint(points, i);
        }
    }

    private void checkPreviousPoint(List<Point> points, int i) {
        if (points.get(i - 1).equals(Point.FILLED)) {
            points.set(i, Point.EMPTY);
        }
    }

    public int moveUserByPath(int index) {
        if (isLeftFilled(index)) {
            return index - 1;
        }
        if (isRightFilled(index)) {
            return index + 1;
        }
        return index;
    }

    private boolean isLeftFilled(int index) {
        return getPointStatus(index - 1).equals(Point.FILLED);
    }

    private boolean isRightFilled(int index) {
        return getPointStatus(index).equals(Point.FILLED);
    }

    private Point getPointStatus(int index) {
        if (index < 0 || index >= points.size()) {
            return Point.EMPTY;
        }
        return points.get(index);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
