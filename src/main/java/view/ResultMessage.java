package view;

import java.util.List;

public enum ResultMessage {
    MOVABLE_LINE("-----|"),
    UNMOVABLE_LINE("     |");

    private static final int FIRST_NAME_INDEX = 0;

    private final String message;

    ResultMessage(String message) {
        this.message = message;
    }

    public static String of(final List<Boolean> points) {
        StringBuilder result = new StringBuilder();
        for (boolean point : points) {
            result.append(currentPoint(point));
        }
        result.append("\n");
        return result.toString();
    }

    private static String currentPoint(final boolean isMovable) {
        if (isMovable) {
            return ResultMessage.MOVABLE_LINE.message;
        }
        return ResultMessage.UNMOVABLE_LINE.message;
    }

    public static String ladderPadding(final List<String> names) {
        return " ".repeat(names.get(FIRST_NAME_INDEX).length()) + "|";
    }
}
