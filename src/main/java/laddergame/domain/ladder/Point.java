package laddergame.domain.ladder;

public enum Point {
    EMPTY, EXIST;

    public static Point from(final boolean input) {
        if (input) {
            return Point.EXIST;
        }
        return Point.EMPTY;
    }

    public Point next(final Point point) {
        if (isExist()) {
            return Point.EMPTY;
        }
        return point;
    }

    public boolean isExist() {
        return this == EXIST;
    }
}
