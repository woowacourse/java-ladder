package laddergame.domain.ladder;

public enum Connection {
    CONNECTED(true),
    NOT_CONNECTED(false);

    private final boolean isConnect;

    Connection(boolean isConnect) {
        this.isConnect = isConnect;
    }

    public boolean isConnected() {
        return isConnect;
    }
}
