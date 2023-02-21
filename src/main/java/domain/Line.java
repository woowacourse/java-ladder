package domain;

import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Point> points;

    public Line(final List<Point> points) {
        this.points = points;
    }

    public int move(final int index) {
        if (hasLeft(index)) {
            return index - 1;
        }

        if (hasRight(index)) {
            return index + 1;
        }

        return index;
    }

    private boolean hasLeft(final int index) {
        if (index == 0) {
            return false;
        }

        Point leftPoint = points.get(index - 1);
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
