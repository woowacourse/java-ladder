package ladder.domain.ladder;

public enum Rung {
    EXIST,
    EMPTY;

    public static Rung from(final boolean exist) {
        if (exist) {
            return EXIST;
        }
        return EMPTY;
    }

    public boolean isExist() {
        return this == EXIST;
    }
}
