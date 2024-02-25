package domain;

public enum Point {
    MOVABLE,
    UNMOVABLE;

    public static boolean isMovable(Point point) {
        return point == MOVABLE;
    }
}
