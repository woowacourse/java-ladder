package domain.ladder;

import utils.ErrorMessage;

import java.util.Arrays;

public enum Bridge {

    TRUE(true, "-----"),
    FALSE(false, "     ");

    private final Boolean flag;
    private final String message;

    Bridge(Boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public static Bridge getBridge(boolean flag) {
        return Arrays.stream(values())
                .filter(bridge -> bridge.flag == flag)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.BRIDGE_NOT_FOUND_ERROR.getMessage()));
    }

    public String getMessage() {
        return message;
    }
}
