package ladder.domain;

import java.util.Arrays;

public enum Direction {

    LEFT(-1, "-----"),
    STAY(0, "     "),
    RIGHT(1, "     "),
    ;

    private final int move;
    private final String foothold;

    Direction(final int move, final String foothold) {
        this.move = move;
        this.foothold = foothold;
    }

    public static Direction from(final int value) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.getMove() == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 값입니다."));
    }

    public int getMove() {
        return move;
    }

    public String getFoothold() {
        return foothold;
    }
}
