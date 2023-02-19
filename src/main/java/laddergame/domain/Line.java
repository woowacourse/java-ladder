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

    public List<Point> getLine() {
        return points;
    }
}
