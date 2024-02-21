package ladder.domain.ladder;

public enum Rung {
    EXIST,
    EMPTY;

    public boolean isExist() {
        return this == EXIST;
    }

    public static Rung of(final boolean exist) {
        if (exist) {
            return EXIST;
        }
        return EMPTY;
    }
}
