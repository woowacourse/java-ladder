package domain;

public enum Point {
    PASSABLE,
    BLOCKED;

    private static final int MIN_NUMBER_RETURN_TRUE = 4;

    public static Point of(int number) {
        if (number >= MIN_NUMBER_RETURN_TRUE) {
            return Point.PASSABLE;
        }
        return Point.BLOCKED;
    }

    public boolean isPassable() {
        return this.equals(PASSABLE);
    }
}
