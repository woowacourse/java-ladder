package model;

import java.util.Arrays;
import java.util.Optional;

public enum Bridge {
    CONNECTED(1),
    UNCONNECTED(0);

    private final int code;

    Bridge(int code) {
        this.code = code;
    }

    public static Optional<Bridge> findBridgeByCode(int code) {
        return Arrays.stream(Bridge.values())
                .filter(bridge -> code == bridge.code)
                .findFirst();
    }

    public boolean isConnected() {
        return this == CONNECTED;
    }
}
