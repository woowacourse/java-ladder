package ladder.domain;

public enum ConnectionStatus {

    CONNECTED(Boolean.TRUE), DISCONNECTED(Boolean.FALSE);

    private final Boolean connectionStatus;

    ConnectionStatus(Boolean connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    public static ConnectionStatus convertConnectionStatus(Boolean isConnected) {
        if (ConnectionStatus.CONNECTED.connectionStatus == isConnected) {
            return CONNECTED;
        }
        return DISCONNECTED;
    }
}
