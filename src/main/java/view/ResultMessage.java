package view;

import domain.Line;
import domain.Names;

public enum ResultMessage {
    MOVABLE_LINE("-----|"),
    UNMOVABLE_LINE("     |");

    private static final int FIRST_NAME_INDEX = 0;

    private final String message;

    ResultMessage(String message) {
        this.message = message;
    }

    public static String of(Line line) {
        StringBuilder result = new StringBuilder();
        for (Boolean point : line.getPoints()) {
            result.append(currentPoint(point));
        }
        result.append("\n");
        return result.toString();
    }

    private static String currentPoint(final boolean point) {
        if (point) {
            return ResultMessage.MOVABLE_LINE.message;
        }
        return ResultMessage.UNMOVABLE_LINE.message;
    }

    public static String ladderPadding(final Names names) {
        return " ".repeat(names.nameOf(FIRST_NAME_INDEX).length()) + "|";
    }
}
