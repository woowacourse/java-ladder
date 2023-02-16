package domain;

import java.util.Arrays;

public enum PointStatus {
    LINE(true, "-"),
    BLANK(false, " ");

    private final boolean point;
    private final String message;

    PointStatus(boolean point, String message) {
        this.point = point;
        this.message = message;
    }

    public static String printStatus(boolean point, int width) {
        StringBuilder msg = new StringBuilder();
        String temp = Arrays.stream(PointStatus.values())
                .filter(pointStatus -> pointStatus.point == point)
                .findAny()
                .orElse(BLANK)
                .message;
        while (width-- > 0) {
            msg.append(temp);
        }
        return msg.toString();
    }
}
