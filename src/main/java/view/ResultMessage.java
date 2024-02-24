package view;

import domain.line.Line;
import domain.Names;
import domain.line.Point;

public enum ResultMessage {
    MOVABLE_LINE("-----|"),
    UNMOVABLE_LINE("     |");

    private final String message;

    ResultMessage(String message) {
        this.message = message;
    }

    public static String of(Line line) {
        StringBuilder result = new StringBuilder();
        for (Point point : line.getPoints()) {
            result.append(lineMessageForPoint(point));
        }
        result.append("\n");
        return result.toString();
    }

    private static String lineMessageForPoint(final Point point) {
        if (point.isConnected()) {
            return ResultMessage.MOVABLE_LINE.message;
        }
        return ResultMessage.UNMOVABLE_LINE.message;
    }

    public static String ladderPadding(final Names names) {
        return " ".repeat(names.firstName().length()) + "|";
    }
}
