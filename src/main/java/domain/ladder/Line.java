package domain.ladder;

import domain.generator.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final String PLAYER_SIZE_ERROR_MESSAGE = "게임 참여자 수는 최소 2명 최대 50명까지 가능합니다.";
    private static final int POINTS_MIN_SIZE = 1;
    private static final int POINTS_MAX_SIZE = 49;

    private final List<Boolean> points = new ArrayList<>();

    public Line(int count, BooleanGenerator booleanGenerator) {
        validate(count);
        createPoints(count, booleanGenerator);
    }

    public Position findNext(Position position) {
        if (position.canMoveLeft(points, position)) {
            return position.moveDirection(Direction.LEFT);
        }
        if (position.canMoveRight(points, position)) {
            return position.moveDirection(Direction.RIGHT);
        }
        return position.moveDirection(Direction.STRAIGHT);
    }

    private void validate(int count) {
        if (count < POINTS_MIN_SIZE || count > POINTS_MAX_SIZE) {
            throw new IllegalArgumentException(PLAYER_SIZE_ERROR_MESSAGE);
        }
    }

    private void createPoints(int count, BooleanGenerator booleanGenerator) {
        for (int index = 0; index < count; index++) {
            addPoint(index, booleanGenerator.generate());
        }
    }

    private void addPoint(int index, boolean flag) {
        if (canMake(flag, index)) {
            points.add(true);
            return;
        }
        points.add(false);
    }

    private boolean canMake(boolean flag, int index) {
        if (flag && isFirstIndexOrLeftEmpty(index)) {
            return true;
        }
        return false;
    }

    private boolean isFirstIndexOrLeftEmpty(int index) {
        return index == 0 || points.get(index - 1) == false;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
