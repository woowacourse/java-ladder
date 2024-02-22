package domain;

import java.util.ArrayList;
import java.util.List;
import strategy.PointStrategy;

public class Line {

    private final List<Boolean> points = new ArrayList<>();
    private final PointStrategy pointStrategy;

    public Line(int playerCount, PointStrategy pointStrategy) {
        this.pointStrategy = pointStrategy; // TODO: 여기서 그냥 new 해도 되지 않나?
        generate(playerCount);
    }

    private void generate(int playerCount) {
        points.add(pointStrategy.generatePoint());
        for (int i = 1; i < playerCount - 1; i++) {
            if (points.get(i - 1)) {
                points.add(false);
                continue;
            }
            points.add(pointStrategy.generatePoint());
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
