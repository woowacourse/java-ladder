package domain;

import java.util.Arrays;

public enum Bridge {
    BRIDGE(true),
    NON_BRIDGE(false);

    private final boolean connection;

    Bridge(final boolean connection) {
        this.connection = connection;
    }

    public boolean isConnected() {
        return connection;
    }

    public static Bridge findByConnection(final boolean connection) {
        return Arrays.stream(values())
                .filter(value -> value.connection == connection)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("bridgeType이 존재하지 않습니다."));
    }
}
