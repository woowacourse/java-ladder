package domain;

import common.exception.message.ExceptionMessage;
import common.exception.model.NotFoundException;
import java.util.Arrays;

public enum LadderBridge {
    BRIDGE("-----", true),
    NONE("     ", false);

    private final String value;
    private final boolean exist;

    LadderBridge(final String value, final boolean exist) {
        this.value = value;
        this.exist = exist;
    }

    public static LadderBridge getByExist(final boolean exist) {
        return Arrays.stream(values())
                .filter(value -> value.exist == exist)
                .findFirst()
                .orElseThrow(() -> new NotFoundException(ExceptionMessage.NOT_FOUND_BRIDGE));
    }

    public String getValue() {
        return value;
    }
}
