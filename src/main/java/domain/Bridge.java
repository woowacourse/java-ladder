package domain;

import java.util.Arrays;

public enum Bridge {
    BRIDGE(true),
    NON_BRIDGE(false);

    private final boolean bridgeType;

    Bridge(final boolean bridgeType) {
        this.bridgeType = bridgeType;
    }

    public boolean getBridge() {
        return bridgeType;
    }

    public static Bridge findByHasLine(boolean bridgeType) {
        return Arrays.stream(values())
                .filter(value -> value.bridgeType == bridgeType)
                .findAny()
                .orElseThrow(()-> new IllegalArgumentException("bridgeType이 존재하지 않습니다."));
    }
}
