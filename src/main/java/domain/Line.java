package domain;

import java.util.ArrayList;
import java.util.List;

import static domain.LineState.UNMOVABLE_STATE;

public class Line {

    private final List<Boolean> points = new ArrayList<>();

    public Line(int personCount, RandomGenerator generator) {
        addPoints(personCount, generator);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private void addPoints(int personCount, RandomGenerator generator) {
        addRandomPoint(generator);
        for (int index = 1; index < personCount - 1; index++) {
            addConditionPoint(generator, index);
        }
    }

    private void addConditionPoint(RandomGenerator generator, int index) {
        if(isSuccessive(index)){
            addPoint(UNMOVABLE_STATE.getState());
        }
        if(!isSuccessive(index)){
            addRandomPoint(generator);
        }
    }

    private boolean isSuccessive(int index){
        return points.get(index - 1);
    }

    private void addRandomPoint(RandomGenerator generator) {
        addPoint(LineState.of(generator.generate()).getState());
    }

    private void addPoint(boolean state) {
        points.add(state);
    }

    public int getPointsSize() {
        return points.size();
    }

    public boolean isMovablePoint(int pointIndex) {
        return points.get(pointIndex);
    }
}
