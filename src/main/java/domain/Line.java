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
        addPoint(generator.generate());
        for (int index = 1; index < personCount - 1; index++) {
            addConditionPoint(generator, index);
        }
    }

    private void addConditionPoint(RandomGenerator generator, int index) {
        if(points.get(index -1)){
            addPoint(IMPOSSIBLE_STATE);
        }
        if(!points.get(index -1)){
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
