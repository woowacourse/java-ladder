package view;

import domain.Link;
import java.util.List;

public class LineRender {
    private static final String BLANK_LINE = "     ";
    private static final String CONNECTED_LINE = "-----";
    private static final String LADDER = "|";

    public static String render(final List<Link> line) {
        final StringBuilder builder = new StringBuilder();
        builder.append(BLANK_LINE);
        builder.append(LADDER);
        for (final Link connected : line) {
            renderPoint(builder, connected);
            builder.append(LADDER);
        }
        return builder.toString();
    }

    private static void renderPoint(final StringBuilder builder, final Link connected) {
        if (connected.isLink()) {
            builder.append(CONNECTED_LINE);
            return;
        }
        builder.append(BLANK_LINE);
    }
}
