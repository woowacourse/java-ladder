package domain.ladder;

import common.exception.model.NotFoundException;

import java.util.Arrays;

public enum LadderBridge {
    BRIDGE("-----", true),
    NONE("     ", false);

    public static final String NOT_FOUND_BRIDGE = "존재하지 않는 Bridge 입니다";

    private final String value;
    private final boolean exist;

    LadderBridge(String value, boolean exist) {
        this.value = value;
        this.exist = exist;
    }

    public static LadderBridge getByExist(boolean exist) {
        return Arrays.stream(values())
                .filter(value -> value.exist == exist)
                .findFirst()
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_BRIDGE));
    }

    public String getValue() {
        return value;
    }
}
