package domain;

import java.util.Arrays;

public enum Point {
    MOVABLE(true),
    UNMOVABLE(false);

    private final boolean isMovable;

    Point(boolean movable) {
        this.isMovable = movable;
    }

    public static boolean isMovable(final Point point) {
        return point.isMovable;
    }

    public static Point of(final boolean isMovable) {
        return Arrays.stream(values())
                .filter(point -> point.isMovable == isMovable)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static boolean valueOf(final Point point) {
        return point.isMovable;
    }
}
