package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = List.copyOf(removeDuplicatedConnection(points));
    }

    private List<Point> removeDuplicatedConnection(List<Point> originalPoints) {
        List<Point> convertedPoints = new ArrayList<>();
        Point prevPoint = Point.DISCONNECT;
        for (Point point : originalPoints) {
            Point currentPoint = Point.findByConnectedCondition(point.isConnected() && !prevPoint.isConnected());
            convertedPoints.add(currentPoint);
            prevPoint = currentPoint;
        }
        return convertedPoints;
    }

    public Position getConnectedPosition(Position position) {
        if (isLeftMovable(position)) {
            return position.getLeftPosition();
        }
        if (isRightMovable(position)) {
            return position.getRightPosition();
        }
        return position;
    }

    private boolean isLeftMovable(Position position) {
        int pointIndex = position.getValue() - 2;
        if (pointIndex < 0) {
            return false;
        }
        return points.get(pointIndex).isConnected();
    }

    private boolean isRightMovable(Position position) {
        int pointIndex = position.getValue() - 1;
        if (points.size() <= pointIndex) {
            return false;
        }
        return points.get(pointIndex).isConnected();
    }

    public List<Point> getLine() {
        return points;
    }
}
