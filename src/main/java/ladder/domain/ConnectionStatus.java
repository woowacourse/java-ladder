package ladder.domain;

import java.sql.Connection;
import java.util.Arrays;

public enum ConnectionStatus {

    CONNECTED(Boolean.TRUE), UNCONNECTED(Boolean.FALSE);

    private final Boolean connectionStatus;

    ConnectionStatus(Boolean connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    public static ConnectionStatus convertConnectionStatus(Boolean isConnected) {
        if (ConnectionStatus.CONNECTED.connectionStatus == isConnected) {
            return CONNECTED;
        }
        return UNCONNECTED;
    }
}
