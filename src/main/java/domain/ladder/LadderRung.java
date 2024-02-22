package domain.ladder;

public enum LadderRung {
    CONNECTED(true),
    NOT_CONNECTED(false);

    private final boolean value;

    LadderRung(final boolean value) {
        this.value = value;
    }

    public static LadderRung findRung(boolean isConnected) {
        if (CONNECTED.value == isConnected) {
            return CONNECTED;
        }
        return NOT_CONNECTED;
    }

    public boolean isConnected() {
        return value;
    }
}
