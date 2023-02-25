package laddergame.domain;

import laddergame.util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Point> points;

    public Line(int playerCount, BooleanGenerator booleanGenerator) {
        final int pointCount = playerCount - 1;
        this.points = List.copyOf(createLine(pointCount, booleanGenerator));
    }

    private List<Point> createLine(int pointCount, BooleanGenerator booleanGenerator) {
        boolean isPreviousConnected = false;
        List<Point> points = new ArrayList<>();
        while (points.size() < pointCount) {
            boolean isCurrentConnected = selectCurrentPoint(isPreviousConnected, booleanGenerator.generate());
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
        if (canMoveRight(currentPosition)) {
            position++;
        }
        if (canMoveLeft(currentPosition)) {
            position--;
        }
        return position;
    }

    private boolean canMoveRight(int position) {
        final int maxPosition = points.size();
        return position < maxPosition && isConnected(position);
    }

    private boolean canMoveLeft(int position) {
        final int minPosition = 0;
        return position > minPosition && isConnected(position - 1);
    }

    private boolean isConnected(int position) {
        return points.get(position).isConnected();
    }
}
