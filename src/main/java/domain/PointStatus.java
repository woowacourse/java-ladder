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
        StringBuilder stringBuilder = new StringBuilder();
        String statusMessage = Arrays.stream(PointStatus.values())
                .filter(pointStatus -> pointStatus.point == point)
                .findAny()
                .orElse(BLANK)
                .message;
        while (width-- > 0) {
            stringBuilder.append(statusMessage);
        }
        return stringBuilder.toString();
    }
}
