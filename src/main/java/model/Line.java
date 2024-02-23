package model;

import java.util.List;
import model.strategy.BuildStrategy;

public class Line {

    private final List<Step> points;

    public Line(int personCount, BuildStrategy<Step> buildStrategy) {
        this.points = buildStrategy.generate(personCount - 1);
    }

    public int size() {
        return points.size();
    }

    public boolean hasStep(int index) {
        return points.get(index).hasStep();
    }

    public List<Step> getPoints() {
        return points;
    }
}
