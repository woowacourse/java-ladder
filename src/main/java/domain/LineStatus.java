package domain;

public enum LineStatus {
    CONNECTED(true),
    DISCONNECTED(false);

    private final boolean isConnected;

    LineStatus(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public static LineStatus getStatus(boolean isConnected) {
        if (isConnected) {
            return CONNECTED;
        }

        return DISCONNECTED;
    }

    public boolean isConnected() {
        return isConnected;
    }
}
