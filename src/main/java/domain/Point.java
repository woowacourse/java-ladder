package domain;

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
        if (isMovable) {
            return MOVABLE;
        }
        return UNMOVABLE;
    }

    public static boolean valueOf(final Point point) {
        return point.isMovable;
    }
}
