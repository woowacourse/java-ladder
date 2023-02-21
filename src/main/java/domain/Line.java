package domain;

import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public int move(int index) {
        Point leftPoint = getLeftPoint(index);
        if (leftPoint != null && leftPoint.isConnected()) {
            return index - 1;
        }

        Point rightPoint = getRightPoint(index);
        if (rightPoint != null && rightPoint.isConnected()) {
            return index + 1;
        }

        return index;
    }

    private Point getLeftPoint(int index) {
        if (index == 0) {
            return null;
        }

        return points.get(index - 1);
    }

    private Point getRightPoint(int index) {
        if (index == points.size()) {
            return null;
        }

        return points.get(index);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
