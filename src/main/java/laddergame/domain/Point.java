package laddergame.domain;

import java.util.Arrays;

public enum Point {
    CONNECT(true, "-----"),
    DISCONNECT(false, "     ");

    private final boolean isConnected;
    private final String displayFormat;

    Point(boolean isConnected, String displayFormat) {
        this.isConnected = isConnected;
        this.displayFormat = displayFormat;
    }

    public static Point findByConnectedCondition(boolean condition) {
        return Arrays.stream(Point.values())
                .filter(point -> point.isConnected == condition)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 올바른 값이 아닙니다."));
    }

    public String getDisplayFormat() {
        return displayFormat;
    }
}
