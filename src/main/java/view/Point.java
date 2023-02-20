package view;

import java.util.Arrays;

public enum Point {

    TRUE(true, "-----"),
    FALSE(false, "     ");

    private static final String POINT_NOT_FOUND_ERROR = "일치하는 포인트 객체가 존재하지 않습니다.";

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
                .orElseThrow(() -> new IllegalArgumentException(POINT_NOT_FOUND_ERROR));
    }

    public String getMessage() {
        return message;
    }
}
