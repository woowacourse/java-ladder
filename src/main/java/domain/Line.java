package domain;

import java.util.ArrayList;
import java.util.List;
import strategy.PointStrategy;

public class Line {

    private final List<Point> points = new ArrayList<>();
    private final PointStrategy pointStrategy;

    public Line(int playerCount, PointStrategy pointStrategy) {
        this.pointStrategy = pointStrategy;
        generate(playerCount);
    }

    private void generate(int playerCount) {
        points.add(pointStrategy.generatePoint());
        for (int i = 1; i < playerCount - 1; i++) {
            points.add(makeNextPointByPrevious(points.get(i - 1)));
        }
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
