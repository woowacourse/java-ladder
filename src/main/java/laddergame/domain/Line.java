package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Stick> sticks = new ArrayList<>();

    public Line(StickGenerator stickGenerator, int playerSize) {
        int sticksSize = playerSize - 1;

        for (int i = 0; i < sticksSize; i++) {
            sticks.add(getStick(stickGenerator));
        }
    }

    private Stick getStick(StickGenerator stickGenerator) {
        Stick stick = stickGenerator.generateOne();

        if (sticks.isEmpty()) {
            return stick;
        }

        if (isRepeatFilled(stick)) {
            return Stick.NOT_FILLED;
        }

        return stick;
    }

    private boolean isRepeatFilled(Stick stick) {
        return isRepeat(stick) && stick.isFilled();
    }

    private boolean isRepeat(Stick stick) {
        Stick lastStick = sticks.get(sticks.size() - 1);

        return lastStick == stick;
    }

    public Direction move(int column) {
        validateColumnSize(column);

        Direction moveLeftResult = moveLeft(column);
        Direction moveRightResult = moveRight(column);

        return moveLeftResult.getHigherPriority(moveRightResult);
    }

    private void validateColumnSize(int column) {
        int columnThreshold = sticks.size();

        if (column < 0 || column > columnThreshold) {
            throw new IllegalArgumentException("주어진 컬럼이 범위를 벗어납니다.");
        }
    }

    private Direction moveLeft(int column) {
        Stick leftStick = findLeftStick(column);
        if (leftStick.isFilled()) {
            return Direction.LEFT;
        }

        return Direction.STAY;
    }

    private Stick findLeftStick(int column) {
        if (column - 1 < 0) {
            return Stick.NOT_FILLED;
        }

        return sticks.get(column - 1);
    }

    private Direction moveRight(int column) {
        Stick rightStick = findRightStick(column);
        if (rightStick.isFilled()) {
            return Direction.RIGHT;
        }

        return Direction.STAY;
    }

    private Stick findRightStick(int column) {
        if (column >= sticks.size()) {
            return Stick.NOT_FILLED;
        }

        return sticks.get(column);
    }

    public List<Stick> getSticks() {
        return sticks;
    }
}
