package domain;

public enum Point {
    PASSABLE,
    BLOCKED;

    private static final int PASSABLE_THRESHOLDS = 4;

    public static Point of(int number) {
        if (number >= PASSABLE_THRESHOLDS) {
            return Point.PASSABLE;
        }
        return Point.BLOCKED;
    }

    public boolean isPassable() {
        return this.equals(PASSABLE);
    }
}
