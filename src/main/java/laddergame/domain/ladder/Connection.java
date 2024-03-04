package laddergame.domain.ladder;

public enum Connection {
    // TODO NOT_CONNECTED
    CONNECTED(true),
    NOTCONNECTED(false);

    private final boolean isConnect;

    Connection(boolean isConnect) {
        this.isConnect = isConnect;
    }

    public boolean isConnected() {
        return isConnect;
    }
}
