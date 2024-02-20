package domain;

import java.util.Arrays;

public enum Direction {
    LEFT(-1),
    RIGHT(1),
    EMPTY(0); // TODO: 더 적절한 네이밍 생각해보기

    private final int value;

    Direction(int value) {
        this.value = value;
    }

    public static Direction getDirectionByValue(int value) {
        return Arrays.stream(Direction.values())
                .filter((direction) -> direction.value == value)
                .findAny()
                .orElseThrow();
    }
}
