package laddergame.domain.ladder;

public enum Point {
    EMPTY, EXIST;

    public boolean isExist() {
        return this == EXIST;
    }

    public Point next(final Point point) {
        if (isExist()) {
            return Point.EMPTY;
        }
        return point;
    }
}
