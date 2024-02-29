package model;

import java.util.Arrays;

public enum Line {

    CONNECTED(true),
    NOT_CONNECTED(false);

    private final Boolean isConnected;

    Line(Boolean isConnected) {
        this.isConnected = isConnected;
    }

    public static Line valueOf(Boolean isConnected) {
        return Arrays.stream(values())
                .filter(liine -> liine.getConnected() == isConnected)
                .findAny()
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 값입니다."));
    }

    public Boolean getConnected() {
        return isConnected;
    }
}
