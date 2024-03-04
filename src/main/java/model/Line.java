package model;

import java.util.Arrays;

public enum Line {

    CONNECTED(true),
    NOT_CONNECTED(false);

    private final boolean value;

    Line(boolean value) {
        this.value = value;
    }

    public static Line valueOf(boolean isConnected) {
        return Arrays.stream(values())
                .filter(line -> line.value == isConnected)
                .findAny()
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 값입니다."));
    }

    public boolean isConnected() {
        return value;
    }
}
