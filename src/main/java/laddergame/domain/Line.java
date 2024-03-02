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

    public Direction move(Column column) {
        validateColumnSize(column);

        Direction moveLeftResult = moveLeft(column);
        Direction moveRightResult = moveRight(column);

        return moveLeftResult.getHigherPriority(moveRightResult);
    }

    private void validateColumnSize(Column column) {
        int columnThreshold = sticks.size();

        if (column.isGreaterThan(columnThreshold)) {
            throw new IllegalArgumentException("주어진 컬럼이 범위를 벗어납니다.");
        }
    }

    private Direction moveLeft(Column column) {
        Stick leftStick = findLeftStick(column);
        if (leftStick.isFilled()) {
            return Direction.LEFT;
        }

        return Direction.STAY;
    }

    private Stick findLeftStick(Column column) {
        if (column.isZero()) {
            return Stick.NOT_FILLED;
        }

        return sticks.get(column.getValue() - 1);
    }

    private Direction moveRight(Column column) {
        Stick rightStick = findRightStick(column);
        if (rightStick.isFilled()) {
            return Direction.RIGHT;
        }

        return Direction.STAY;
    }

    private Stick findRightStick(Column column) {
        if (column.isGreaterThan(sticks.size() - 1)) {
            return Stick.NOT_FILLED;
        }

        return sticks.get(column.getValue());
    }

    public List<Stick> getSticks() {
        return sticks;
    }
}
