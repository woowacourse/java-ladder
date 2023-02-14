package view;

import domain.Line;

import java.util.List;

public class OutputView {
    private static final String BLANK_LINE = "     ";
    private static final String CONNECTED_LINE = "-----";
    private static final String LADDER = "|";

    public void printResult(List<Line> lines) {
        for (Line line : lines) {
            System.out.println(renderLine(line));
        }
    }

    private String renderLine(Line line) {
        StringBuilder builder = new StringBuilder();
        builder.append(BLANK_LINE);
        builder.append(LADDER);
        for (Boolean connected : line.getPoints()) {
            renderPoint(builder, connected);
            builder.append(LADDER);
        }
        return builder.toString();
    }

    private static void renderPoint(StringBuilder builder, Boolean connected) {
        if (connected) {
            builder.append(CONNECTED_LINE);
            return;
        }
        System.out.print(BLANK_LINE);
    }
}
