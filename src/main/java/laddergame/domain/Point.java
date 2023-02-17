package laddergame.domain;

import laddergame.constant.ErrorMessage;

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
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_VALID_ARGUMENT.getMessage()));
    }

    public boolean isConnected() {
        return isConnected;
    }
}
