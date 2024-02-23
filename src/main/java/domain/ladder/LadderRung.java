package domain.ladder;

public enum LadderRung {
    CONNECTED,
    DISCONNECTED;

    public static LadderRung findLadderRung(boolean isConnected) {
        if (isConnected) {
            return CONNECTED;
        }
        return DISCONNECTED;
    }

    public boolean isConnected() {
        return this.equals(CONNECTED);
    }
}
