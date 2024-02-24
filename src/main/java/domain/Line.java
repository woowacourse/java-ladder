package domain;

import java.util.ArrayList;
import java.util.List;
import strategy.PointStrategy;

public class Line {

    private final List<Connection> points = new ArrayList<>();
    private final PointStrategy pointStrategy;

    public Line(int memberCount, PointStrategy pointStrategy) {
        this.pointStrategy = pointStrategy;
        generate(memberCount);
    }

    private void generate(int memberCount) {
        Connection first = pointStrategy.generatePoint();
        points.add(first);

        for (int i = 1; i < memberCount - 1; i++) {
            Connection previous = points.get(i - 1);
            Connection next = previous.makeNextConnection(pointStrategy);
            points.add(next);
        }
    }

    public List<Connection> getPoints() {
        return points;
    }
}
