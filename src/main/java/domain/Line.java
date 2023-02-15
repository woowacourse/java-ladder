package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final int POSSIBLE_STATE = 1;
    private static final int IMPOSSIBLE_STATE = 0;

    private final List<Boolean> points = new ArrayList<>();

    public Line(int personCount, RandomGenerator generator) {
        addPoints(personCount, generator);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private void addPoints(int personCount, RandomGenerator generator) {
        for (int i = 0; i < personCount - 1; i++) {
            addPoint(generator.generate());
        }
    }

    private void addPoint(int state) {
        if (state == POSSIBLE_STATE) {
            points.add(true);
        }
        if (state == IMPOSSIBLE_STATE) {
            points.add(false);
        }
    }

    public int getPointsSize() {
        return points.size();
    }

}
