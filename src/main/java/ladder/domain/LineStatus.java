package ladder.domain;

public enum LineStatus {
    GO,
    STOP;

    public static LineStatus from(final boolean status) {
        if (status) {
            return GO;
        }
        return STOP;
    }
}
