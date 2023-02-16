package laddergame.domain;

import laddergame.util.PointGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Point> points;

    public Line(int playerCount, PointGenerator pointGenerator) {
        final int pointCount = playerCount - 1;
        this.points = List.copyOf(createLine(pointCount, pointGenerator));
    }

    private List<Point> createLine(int pointCount, PointGenerator pointGenerator) {
        boolean isPreviousConnected = false;
        List<Point> points = new ArrayList<>();
        while (points.size() < pointCount) {
            boolean isCurrentConnected = selectCurrentPoint(isPreviousConnected, pointGenerator.generate());
            points.add(Point.findByConnectedCondition(isCurrentConnected));
            isPreviousConnected = isCurrentConnected;
        }
        return points;
    }

    private boolean selectCurrentPoint(boolean isPreviousConnected, boolean isCurrentConnected) {
        if (isPreviousConnected && isCurrentConnected) {
            return false;
        }
        return isCurrentConnected;
    }

    public List<Point> getLine() {
        return points;
    }
}
