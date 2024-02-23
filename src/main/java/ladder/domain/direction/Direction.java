package ladder.domain.direction;

import java.util.Arrays;

public enum Direction {
    RIGHT(0),
    NEUTRAL(1),
    LEFT(2);

    private final int id;

    Direction(int id) {
        this.id = id;
    }

    public static Direction getDirection(int id) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.id == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 방향값이 올바르지 않습니다."));
    }
}
