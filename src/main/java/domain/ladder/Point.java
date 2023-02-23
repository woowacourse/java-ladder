package domain.ladder;

public enum Point {
    EXIST(true),
    NOT_EXIST(false);

    private final boolean isExist;

    Point(boolean isExist) {
        this.isExist = isExist;
    }

    public static Point of(final boolean isExist) {
        if (EXIST.isExist() == isExist) {
            return EXIST;
        }
        return NOT_EXIST;
    }

    public static Point choosePoint(final Point previousPoint, final PointGenerator pointGenerator) {
        if (previousPoint == EXIST) {
            return NOT_EXIST;
        }
        return choosePoint(pointGenerator);
    }

    public static Point choosePoint(final PointGenerator pointGenerator) {
        return pointGenerator.generate();
    }

    public boolean isExist() {
        return this.isExist;
    }

}
