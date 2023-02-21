package domain;

public enum Point {

    EXIST(true),
    NOT_EXIST(false);

    private final boolean isExist;

    Point(boolean isExist) {
        this.isExist = isExist;
    }

    public static Point of(final boolean isExist) {
        if (isExist) {
            return EXIST;
        }
        return NOT_EXIST;
    }

    public boolean isExist() {
        return this.isExist;
    }

}
