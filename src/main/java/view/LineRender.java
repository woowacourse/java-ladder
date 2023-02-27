package view;

import domain.ladder.Line;
import domain.ladder.Link;

public class LineRender {

    private static final String BLANK_LINE = "     ";
    private static final String CONNECTED_LINE = "-----";
    private static final String LADDER = "|";

    private LineRender() {
    }

    public static String render(final Line line) {
        final StringBuilder builder = new StringBuilder();
        builder.append(BLANK_LINE);
        builder.append(LADDER);
        for (final Link connected : line.getLinks()) {
            renderPoint(builder, connected);
            builder.append(LADDER);
        }
        return builder.toString();
    }

    private static void renderPoint(final StringBuilder builder, final Link connected) {
        if (connected.isLinked()) {
            builder.append(CONNECTED_LINE);
            return;
        }
        builder.append(BLANK_LINE);
    }
}
