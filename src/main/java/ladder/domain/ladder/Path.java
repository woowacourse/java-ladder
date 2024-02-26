package ladder.domain.ladder;

public enum Path {
    EMPTY,
    EXIST;

    public static Path from(final boolean isAvailable) {
        if (isAvailable) {
            return EXIST;
        }
        return EMPTY;
    }

    public boolean isExist() {
        return this.equals(EXIST);
    }
}
