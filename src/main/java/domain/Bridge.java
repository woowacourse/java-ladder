package domain;

import java.util.List;
import java.util.stream.Collectors;

public enum Bridge {
    CONNECTED(true), UNCONNECTED(false);

    private final boolean isConnected;

    Bridge(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public static Bridge from(boolean generate) {
        if (generate) {
            return Bridge.CONNECTED;
        }
        return Bridge.UNCONNECTED;
    }

    public static List<Boolean> convertToConnectionStatus(List<Bridge> bridges) {
        return bridges
                .stream()
                .map(bridge -> bridge.isConnected)
                .collect(Collectors.toList());
    }

}
