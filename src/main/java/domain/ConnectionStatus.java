package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ConnectionStatus {

    CONNECTED(true),
    DISCONNECTED(false);

    private final boolean connect;

    ConnectionStatus(boolean connect) {
        this.connect = connect;
    }

    public static List<ConnectionStatus> getAllStatus() {
        return Arrays.stream(ConnectionStatus.values()).collect(Collectors.toList());
    }

    public boolean isConnect() {
        return connect;
    }
}
