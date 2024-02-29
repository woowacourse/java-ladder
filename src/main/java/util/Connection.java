package util;

import java.util.Arrays;

public enum Connection {
    CONNECTED(true, "-----|"),
    UNCONNECTED(false, "     |");

    private final Boolean connected;
    private final String bridge;

    Connection(Boolean connected, String bridge) {
        this.connected = connected;
        this.bridge = bridge;
    }

    public String getBridge() {
        return bridge;
    }

    public static Connection valueOfBridge(boolean isConnected) {
        return Arrays.stream(Connection.values())
                .filter(connection -> isEqualsToConnected(isConnected, connection))
                .findAny()
                .orElse(null);
    }

    private static boolean isEqualsToConnected(boolean isConnected, Connection connection) {
        return connection.connected.equals(isConnected);
    }
}
