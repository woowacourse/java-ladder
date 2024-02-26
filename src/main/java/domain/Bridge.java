package domain;

import java.util.Arrays;

public enum Bridge {

    BRIDGE(true),
    NON_BRIDGE(false);

    private final boolean bridgeStatus;

    Bridge(final boolean bridgeStatus) {
        this.bridgeStatus = bridgeStatus;
    }

    public boolean getBridge() {
        return bridgeStatus;
    }

    public static Bridge findByHasBridge(boolean bridgeStatus) {
        return Arrays.stream(values())
                .filter(value -> value.bridgeStatus == bridgeStatus)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당 Bridge가 존재하지 않습니다."));
    }

}
