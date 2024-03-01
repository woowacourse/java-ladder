package domain.ladder;

public enum Bridge {
    EMPTY, EXIST;

    public static Bridge of(final boolean existence) {
        if (existence) {
            return EXIST;
        }
        return EMPTY;
    }

    public boolean isExist() {
        return this == EXIST;
    }

    public boolean isEmpty() {
        return this == EMPTY;
    }
}
