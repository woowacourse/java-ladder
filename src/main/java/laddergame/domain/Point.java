package laddergame.domain;

import laddergame.constant.ErrorCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Point {
    CONNECT(true),
    DISCONNECT(false);

    private static final Map<Boolean, Point> BY_CONDITION
            = Stream.of(values()).collect(Collectors.toUnmodifiableMap(Point::isConnected, Function.identity()));

    private final boolean isConnected;

    Point(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public static Point findByConnectedCondition(boolean condition) {
        return BY_CONDITION.get(condition);
    }

    public boolean isConnected() {
        return isConnected;
    }
}
