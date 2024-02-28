package domain.ladder;

import common.exception.model.NotFoundException;

import java.util.Arrays;

public enum LadderBridge {
    BRIDGE(true),
    NONE(false);

    public static final String NOT_FOUND_ERROR_MESSAGE = "존재하지 않는 Bridge 입니다";

    private final boolean exist;

    LadderBridge(boolean exist) {
        this.exist = exist;
    }

    public static LadderBridge getByExist(boolean exist) {
        return Arrays.stream(values())
                .filter(value -> value.exist == exist)
                .findFirst()
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_ERROR_MESSAGE));
    }

    public boolean isExist() {
        return exist;
    }
}
