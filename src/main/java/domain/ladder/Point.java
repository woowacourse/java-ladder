package domain.ladder;

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
                .orElseThrow(() -> new IllegalArgumentException("일치하는 객체가 존재하지 않습니다."));
    }

    public String getMessage() {
        return message;
    }
}
