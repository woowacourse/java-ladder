package view;

import domain.Line;
import domain.Point;

import java.util.List;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String BLANK_LINE = "     ";
    private static final String CONNECTED_LINE = "-----";
    private static final String LADDER = "|";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
        System.out.println();
    }

    public static void printUserNames(List<String> userNames) {
        String formattedUserNames = formatUserNames(userNames);
        System.out.println(formattedUserNames);
    }

    public static void printResult(List<Line> lines) {
        for (Line line : lines) {
            System.out.println(renderLine(line));
        }
    }

    private static String formatUserNames(List<String> userNames) {
        StringBuilder builder = new StringBuilder();
        for (String userName : userNames) {
            String formattedUserName = String.format("%6s", userName);
            builder.append(formattedUserName);
        }
        return builder.toString();
    }

    private static String renderLine(Line line) {
        StringBuilder builder = new StringBuilder();
        builder.append(BLANK_LINE);
        builder.append(LADDER);
        for (Point connected : line.getPoints()) {
            renderPoint(builder, connected);
            builder.append(LADDER);
        }
        return builder.toString();
    }

    private static void renderPoint(StringBuilder builder, Point connected) {
        if (connected.isLink()) {
            builder.append(CONNECTED_LINE);
            return;
        }
        builder.append(BLANK_LINE);
    }
}
