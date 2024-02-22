package domain.ladder;

public enum LadderRung {
    CONNECTED(true),
    DISCONNECTED(false);

    private final boolean value;

    LadderRung(boolean value) {
        this.value = value;
    }

    public static LadderRung findLadderRung(boolean isConnected) {
        if (CONNECTED.value == isConnected) {
            return CONNECTED;
        }
        return DISCONNECTED;
    }

    public boolean isConnected() {
        return this.value;
    }
}
