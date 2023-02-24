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

    public int move(int currentPosition) {
        int position = currentPosition;
        int playerCount = points.size() + 1;
        if (canMoveRight(currentPosition, playerCount)) {
            position++;
        }
        if (canMoveLeft(currentPosition, playerCount)) {
            position--;
        }
        return position;
    }

    private boolean canMoveRight(int position, int playerCount) {
        return position < playerCount - 1 && points.get(position).isConnected();
    }

    private boolean canMoveLeft(int position, int playerCount) {
        return position > 0 && points.get(position - 1).isConnected();
    }
}
