package laddergame.domain.bridge;

public enum Bridge {
    EMPTY, EXIST;

    public static Bridge from(final boolean value) {
        if (value) {
            return EXIST;
        }

        return EMPTY;
    }

    public boolean isExist() {
        return this.equals(EXIST);
    }
}
