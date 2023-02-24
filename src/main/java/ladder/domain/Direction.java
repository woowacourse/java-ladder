package ladder.domain;

import java.util.Arrays;

public enum Direction {

    LEFT(-1),
    STAY(0),
    RIGHT(1),
    ;

    private static final String INVALID_VALUE_MESSAGE = "해당 값을 가지는 방향이 존재하지 않습니다.";

    private final int move;

    Direction(final int move) {
        this.move = move;
    }

    public static Direction from(final int value) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.getMove() == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_VALUE_MESSAGE));
    }

    public int getMove() {
        return move;
    }
}
