package laddergame.domain;

public enum Point {
    EMPTY, EXIST;

    public static Point from(final boolean value) {
        if (value) {
            return EXIST;
        }

        return EMPTY;
    }

    public boolean isExist() {
        return this.equals(EXIST);
    }
}
