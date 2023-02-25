package laddergame.domain.ladder;

public enum Connection {

    CONNECTED(true),
    UNCONNECTED(false);

    private final boolean isConnected;

    Connection(final boolean isConnected) {
        this.isConnected = isConnected;
    }

    public static Connection from(final boolean isConnected) {
        if (isConnected) {
            return CONNECTED;
        }

        return UNCONNECTED;
    }

    public boolean isOverlap(final Connection pick) {
        return this.isConnected && pick.isConnected;
    }

    public boolean isConnected() {
        return isConnected;
    }
}
