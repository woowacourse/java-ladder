package domain;

import java.util.Collections;
import java.util.List;

public class Line {

    private static final int LEFT_ENDPOINTS = 0;
    private static final int DELTA = 1;

    private final List<Point> points;

    public Line(final List<Point> points) {
        this.points = points;
    }

    public int move(final int index) {
        if (hasLeft(index)) {
            return index - DELTA;
        }

        if (hasRight(index)) {
            return index + DELTA;
        }

        return index;
    }

    private boolean hasLeft(final int index) {
        if (index == LEFT_ENDPOINTS) {
            return false;
        }

        Point leftPoint = points.get(index - DELTA);
        return leftPoint.isConnected();
    }

    private boolean hasRight(final int index) {
        if (index == points.size()) {
            return false;
        }

        Point rightPoint = points.get(index);
        return rightPoint.isConnected();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
