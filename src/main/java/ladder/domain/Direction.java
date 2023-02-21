package ladder.domain;

import java.util.Arrays;

public enum Direction {
    LEFT(-1, true, false),
    RIGHT(1, false, true),
    NONE(0, false, false);

    private int moveValue;
    private boolean isLeftExist;
    private boolean isRightExist;

    Direction(int moveValue, boolean isLeftExist, boolean isRightExist) {
        this.moveValue = moveValue;
        this.isLeftExist = isLeftExist;
        this.isRightExist = isRightExist;
    }

    public static Direction of(boolean isLeftExist, boolean isRightExist) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.isLeftExist == isLeftExist && direction.isRightExist == isRightExist)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 방향은 움직일 수 없습니다."));
    }

    public int getMoveValue() {
        return this.moveValue;
    }
}
