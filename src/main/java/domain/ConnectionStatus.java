package domain;

public enum ConnectionStatus {

    CONNECTED(Boolean.TRUE),
    DISCONNECTED(Boolean.FALSE);

    private final boolean connect;

    ConnectionStatus(boolean connect) {
        this.connect = connect;
    }

    public boolean isConnect() {
        return connect;
    }
}
