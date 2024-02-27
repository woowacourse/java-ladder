package model;

import java.util.List;
import model.strategy.BuildStrategy;

public class Line {

    private final List<LadderStatus> points;

    public Line(final int personCount, final BuildStrategy<LadderStatus> buildStrategy) {
        this.points = buildStrategy.generate(personCount - 1);
    }

    public int size() {
        return points.size();
    }

    public boolean isConnected(final int index) {
        return points.get(index).isConnected();
    }

    public LadderStatus getLadderStatus(final int index) {
        return points.get(index);
    }

    public List<LadderStatus> getPoints() {
        return points;
    }
}
