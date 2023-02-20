package domain;

import static domain.LineState.UNMOVABLE_STATE;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points = new ArrayList<>();

    public Line(int width, RandomGenerator generator) {
        addPoints(width, generator);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public int getPointsSize() {
        return points.size();
    }

    public boolean isMovablePoint(int pointIndex) {
        return points.get(pointIndex);
    }

    private void addPoints(int width, RandomGenerator generator) {
        addRandomPoint(generator);
        for (int pointIndex = 1; pointIndex < width; pointIndex++) {
            addConditionalPoint(generator, pointIndex);
        }
    }

    private void addConditionalPoint(RandomGenerator generator, int pointIndex) {
        if (isSuccessive(pointIndex)) {
            addPoint(UNMOVABLE_STATE.getState());
            return;
        }
        addRandomPoint(generator);
    }

    private boolean isSuccessive(int index) {
        return points.get(index - 1);
    }

    private void addRandomPoint(RandomGenerator generator) {
        addPoint(LineState.of(generator.generate()).getState());
    }

    private void addPoint(boolean state) {
        points.add(state);
    }

}
