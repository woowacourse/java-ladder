package ladder.domain;

import java.util.Arrays;

public enum Direction {
    RIGHT(0, "R"),
    NEUTRAL(1, "N"),
    LEFT(2, "L");

    private final int id;
    private final String sign;

    Direction(int id, String sign) {
        this.id = id;
        this.sign = sign;
    }

    public static Direction getDirection(int id) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.id == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 방향값이 올바르지 않습니다."));
    }
}
