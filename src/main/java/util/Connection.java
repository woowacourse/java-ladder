package util;

import java.util.Arrays;

public enum Connection {
    CONNECTED(true, "-----|"),
    UNCONNECTED(false, "     |");

    private final Boolean isConnected;
    private final String bridge;

    Connection(Boolean isConnected, String bridge) {
        this.isConnected = isConnected;
        this.bridge = bridge;
    }

    public String getBridge() {
        return bridge;
    }

    public static Connection valueOfBridge(boolean isConnected) {
        return Arrays.stream(Connection.values())
                .filter(connection -> connection.isConnected.equals(isConnected))
                .findAny()
                .orElse(null);
    }
}
