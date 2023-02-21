package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import laddergame.utils.LineMaker;

public class Line {

    private final List<Point> points;

    public Line(LineMaker lineMaker, int userCount) {
        this.points = new ArrayList<>();
        addPoint(lineMaker.generateLine(userCount));
    }

    private void addPoint(List<Point> randomPoints) {
        for (Point randomPoint : randomPoints) {
            points.add(convertPoint(randomPoint));
        }
    }

    private Point convertPoint(Point randomPoint) {
        if (checkFront()) {
            return new Point(false);
        }
        return randomPoint;
    }

    private boolean checkFront() {
        int lastIndex = points.size() - 1;

        boolean hasPoint = !points.isEmpty();
        boolean isPreviousPointConnected = points.get(lastIndex).isConnected();

        return hasPoint && isPreviousPointConnected;
    }

    public List<Point> getPoints() {
        return points;
    }

}
