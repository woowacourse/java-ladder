package domain;

import java.util.ArrayList;
import java.util.List;

import static domain.LineState.UNMOVABLE_STATE;

public class Line {

    private static final int FIRST_INDEX = 1;
    private static final int LAST_INDEX_OFFSET = 1;

    private final List<Boolean> points = new ArrayList<>();

    public Line(int playerCount, RandomGenerator generator) {
        addPoints(playerCount, generator);
    }

    public int getPointsSize() {
        return points.size();
    }

    public boolean isMovablePoint(int pointIndex) {
        return points.get(pointIndex);
    }

    private void addPoints(int playerCount, RandomGenerator generator) {
        addRandomPoint(generator);
        for (int pointIndex = FIRST_INDEX; pointIndex < playerCount - LAST_INDEX_OFFSET; pointIndex++) {
            addConditionalPoint(generator, pointIndex);
        }
    }

    private void addConditionalPoint(RandomGenerator generator, int pointIndex) {
        if(isSuccessive(pointIndex)){
            addPoint(UNMOVABLE_STATE.getState());
            return;
        }
        addRandomPoint(generator);
    }

    private boolean isSuccessive(int index){
        return points.get(index - 1);
    }

    private void addRandomPoint(RandomGenerator generator) {
        addPoint(generator.generate());
    }

    private void addPoint(boolean state) {
        points.add(state);
    }

    public Direction getDirection(int position) {
        if (isLeft(position)) {
            return Direction.LEFT;
        }
        if (isRight(position)) {
            return Direction.RIGHT;
        }
        return Direction.STRAIGHT;
    }

    private boolean isRight(int position) {
        return !isLastPosition(position) && points.get(position);
    }

    private boolean isLastPosition(int position) {
        return position == points.size();
    }

    private boolean isLeft(int position) {
        return position != 0 && points.get(position - 1);
    }

    public List<Boolean> getPoints() {
        return points;
    }

}
