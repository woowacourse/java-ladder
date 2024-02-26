package domain;

import common.exception.message.ExceptionMessage;
import java.util.EnumSet;

public enum LadderBridge {
    BRIDGE(true),
    NONE(false);

    private final boolean exist;

    LadderBridge(final boolean exist) {
        this.exist = exist;
    }

    public static LadderBridge getByExist(final boolean exist) {
        return EnumSet.allOf(LadderBridge.class).stream()
                .filter(value -> value.exist == exist)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NOT_FOUND_BRIDGE));
    }

    public boolean isExist(LadderBridge ladderBridge) {
        return ladderBridge.exist;
    }
}
