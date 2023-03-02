package ladder.domain;

import java.util.Arrays;

public enum Direction {

    LEFT(-1, true),
    STAY(0, false),
    RIGHT(1, false),
    ;

    private final int value;
    private final boolean footholdStatus;

    Direction(final int value, final boolean footholdStatus) {
        this.value = value;
        this.footholdStatus = footholdStatus;
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

    public boolean getFootholdStatus() {
        return footholdStatus;
    }
}
