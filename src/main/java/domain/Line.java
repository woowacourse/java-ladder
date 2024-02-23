package domain;

import java.util.ArrayList;
import java.util.List;
import strategy.PointStrategy;

public class Line {

    private final PointStrategy pointStrategy;
    private final List<Point> points;

    public Line(PointStrategy pointStrategy, int playerCount) {
        this.pointStrategy = pointStrategy;
        this.points = initialize(playerCount);
    }

    private List<Point> initialize(int playerCount) {
        List<Point> points = new ArrayList<>();
        points.add(pointStrategy.generatePoint());
        for (int i = 1; i < playerCount - 1; i++) {
            points.add(makeNextPointByPrevious(points.get(i - 1)));
        }
        return points;
    }

    private Point makeNextPointByPrevious(Point previous) {
        if (previous.equals(Point.CONNECTED)) {
            return Point.DISCONNECTED;
        }
        return pointStrategy.generatePoint();
    }

    public List<Point> getPoints() {
        return points;
    }
}
