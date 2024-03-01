package model;

import java.util.Arrays;

public enum Line {

    CONNECTED(true),
    NOT_CONNECTED(false);

    private final Boolean value;

    Line(Boolean value) {
        this.value = value;
    }

    public static Line valueOf(Boolean value) {
        return Arrays.stream(values())
                .filter(liine -> liine.isConnected() == value)
                .findAny()
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 값입니다."));
    }

    public Boolean isConnected() {
        return value;
    }
}
