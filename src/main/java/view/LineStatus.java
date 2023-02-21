package view;

import java.util.Arrays;

public enum LineStatus {
    MOVE(true, "-"),
    STOP(false, " ");

    private final boolean status;
    private final String message;

    LineStatus(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public static String printStatus(boolean status, int width) {
        StringBuilder stringBuilder = new StringBuilder();
        String statusMessage = Arrays.stream(LineStatus.values())
                .filter(lineStatus -> lineStatus.status == status)
                .findAny()
                .orElse(STOP)
                .message;
        while (width-- > 0) {
            stringBuilder.append(statusMessage);
        }
        return stringBuilder.toString();
    }
}
