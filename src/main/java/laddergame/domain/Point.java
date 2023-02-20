package laddergame.domain;

import laddergame.constant.ErrorCode;

import java.util.Arrays;

public enum Point {
    CONNECT(true),
    DISCONNECT(false);

    private final boolean isConnected;

    Point(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public static Point findByConnectedCondition(boolean condition) {
        return Arrays.stream(Point.values())
                .filter(point -> point.isConnected == condition)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorCode.NOT_VALID_ARGUMENT.getCode()));
    }

    public boolean isConnected() {
        return isConnected;
    }
}
