package ladder.domain.ladder;

public enum Rung {
    EXIST,
    EMPTY;

    public static Rung of(boolean exist) {
        if (exist) {
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
