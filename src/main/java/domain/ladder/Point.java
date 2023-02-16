package domain.ladder;

import utils.ErrorMessage;

import java.util.Arrays;

public enum Point {

    TRUE(true, "-----"),
    FALSE(false, "     ");

    private final Boolean flag;
    private final String message;

    Point(Boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public static Point getPoint(boolean flag) {
        return Arrays.stream(values())
                .filter(point -> point.flag == flag)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.POINT_NOT_FOUND_ERROR.getMessage()));
    }

    public String getMessage() {
        return message;
    }
}
