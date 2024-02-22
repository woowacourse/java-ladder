package domain;

import common.exception.message.ExceptionMessage;
import common.exception.model.NotFoundException;
import java.util.Arrays;

public enum LadderBridge {
    BRIDGE("-----", true),
    NONE("     ", false);

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
                .orElseThrow(() -> new NotFoundException(ExceptionMessage.NOT_FOUND_BRIDGE));
    }

    public String getValue() {
        return value;
    }
}
