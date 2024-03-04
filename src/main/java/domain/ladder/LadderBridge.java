package domain.ladder;

import java.util.EnumSet;

public enum LadderBridge {
    BRIDGE(true),
    NONE(false);

    public static final String NOT_FOUND_BRIDGE = "존재하지 않는 Bridge 입니다";

    private final boolean exist;

    LadderBridge(final boolean exist) {
        this.exist = exist;
    }

    public static LadderBridge getByExist(final boolean exist) {
        return EnumSet.allOf(LadderBridge.class).stream()
                .filter(value -> value.exist == exist)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_BRIDGE));
    }

    public boolean isExist() {
        return exist;
    }
}
