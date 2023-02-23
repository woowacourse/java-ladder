package ladder.domain;

import java.util.Arrays;

public enum Direction {

    LEFT(-1, "-----"),
    STAY(0, "     "),
    RIGHT(1, "     "),
    ;

    private final int value;
    private final String foothold;

    Direction(final int value, final String foothold) {
        this.value = value;
        this.foothold = foothold;
    }

    public static Direction from(final int value) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.getValue() == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 값입니다."));
    }

    public int getValue() {
        return value;
    }

    public String getFoothold() {
        return foothold;
    }
}
