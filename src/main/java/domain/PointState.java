package domain;

import java.util.Arrays;

public enum PointState {
    EMPTY(0),
    CONNECT_NEXT_POINT(1);

    private final int code;

    PointState(final int code) {
        this.code = code;
    }

    public static PointState findStateByCode(final int code) {
        return Arrays.stream(values())
                .filter(value -> value.code == code)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("유효한 코드가 아닙니다"));
    }
}
