package laddergame.domain;

import laddergame.util.PointGenerator;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> points;

    // todo: refactoring..
    public Line(int playerCount, PointGenerator pointGenerator) {
        final int pointCount = playerCount - 1;
        this.points = List.copyOf(createLine(playerCount, pointGenerator));
    }

    private List<Boolean> createLine(int pointCount, PointGenerator pointGenerator) {
        boolean previousPoint = false;
        List<Boolean> tempPoints = new ArrayList<>();
        while (tempPoints.size() < pointCount) {
            boolean currentPoint = selectCurrentPoint(previousPoint, pointGenerator.generate());
            tempPoints.add(currentPoint);
            previousPoint = currentPoint;
        }
        return tempPoints;
    }
    
    private Boolean selectCurrentPoint(boolean previousPoint, boolean currentPoint) {
        if (previousPoint && currentPoint) {
            return false;
        }
        return currentPoint;
    }

    public List<Boolean> getLine() {
        return points;
    }
}
