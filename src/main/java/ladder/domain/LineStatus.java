package ladder.domain;

public enum LineStatus {
    CONNECTED,
    DISCONNECTED;

    public static LineStatus from(final boolean status) {
        if (status) {
            return CONNECTED;
        }
        return DISCONNECTED;
    }

    public boolean isConnected() {
        return this == CONNECTED;
    }

    public boolean isDisconnected() {
        return this == DISCONNECTED;
    }
}
