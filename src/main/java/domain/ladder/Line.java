package domain.ladder;

import domain.generator.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final String PLAYER_SIZE_ERROR_MESSAGE = "게임 참여자 수는 최소 2명 최대 50명까지 가능합니다.";
    private static final int POINTS_MIN_SIZE = 1;
    private static final int POINTS_MAX_SIZE = 49;

    private final List<Boolean> points = new ArrayList<>();

    public Line(int playerCount, BooleanGenerator booleanGenerator) {
        validate(playerCount);
        createPoints(playerCount, booleanGenerator);
    }

    public Direction findNext(Position position) {
        if (canMoveLeft(position)) {
            return Direction.LEFT;
        }
        if (canMoveRight(position)) {
            return Direction.RIGHT;
        }
        return Direction.STRAIGHT;
    }

    private void validate(int playerCount) {
        int pointCount = playerCount - 1;
        if (pointCount < POINTS_MIN_SIZE || pointCount > POINTS_MAX_SIZE) {
            throw new IllegalArgumentException(PLAYER_SIZE_ERROR_MESSAGE);
        }
    }

    private void createPoints(int playerCount, BooleanGenerator booleanGenerator) {
        int pointCount = playerCount - 1;
        for (int index = 0; index < pointCount; index++) {
            boolean createdPoint = createPoint(index, booleanGenerator);
            points.add(createdPoint);
        }
    }

    private boolean createPoint(int index, BooleanGenerator booleanGenerator) {
        if (isFirstIndexOrLeftEmpty(index)) {
            return booleanGenerator.generate();
        }
        return false;
    }

    private boolean canMoveLeft(Position position) {
        int playerPosition = position.getValue();
        return playerPosition > 0 && points.get(playerPosition - 1);
    }

    private boolean canMoveRight(Position position) {
        int playerPosition = position.getValue();
        return playerPosition < points.size() && points.get(playerPosition);
    }

    private boolean isFirstIndexOrLeftEmpty(int index) {
        return index == 0 || points.get(index - 1) == false;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
