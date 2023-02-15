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

    // todo: point를 어디까지 적용할 것인가
    private List<Point> createLine(int pointCount, PointGenerator pointGenerator) {
        boolean previousPoint = false;
        List<Point> tempPoints = new ArrayList<>();
        while (tempPoints.size() < pointCount) {
            boolean currentPoint = selectCurrentPoint(previousPoint, pointGenerator.generate());
            tempPoints.add(Point.findByConnectedCondition(currentPoint));
            previousPoint = currentPoint;
        }
        return tempPoints;
    }

    private boolean selectCurrentPoint(boolean previousPoint, boolean currentPoint) {
        if (previousPoint && currentPoint) {
            return false;
        }
        return currentPoint;
    }

    public List<Point> getLine() {
        return points;
    }
}
