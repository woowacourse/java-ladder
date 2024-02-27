package laddergame.view;

import laddergame.domain.gameelements.Elements;
import laddergame.domain.ladder.Connection;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.RowLine;

import java.util.stream.Collectors;

public class MessageResolver {
    private static final int INTERVAL_WIDTH = 5;
    private static final String BLANK = " ";
    private static final String ELEMENT_MESSAGE_FORMAT = "%-" + INTERVAL_WIDTH + "s";
    private static final String CONNECT_MESSAGE = "-".repeat(INTERVAL_WIDTH);
    private static final String NOTCONNECT_MESSAGE = " ".repeat(INTERVAL_WIDTH);
    private static final String VERTICAL_LINE = "|";

    public static String resolveElementMessage(Elements elements) {
        return elements.getElements().stream()
                .map(element -> String.format(ELEMENT_MESSAGE_FORMAT, element.getElement()))
                .collect(Collectors.joining(BLANK));
    }

    public static String resolveLadderMessage(Ladder ladder) {
        return ladder.getRowLines()
                .stream()
                .map(MessageResolver::resolveRowLineMessage)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private static String resolveRowLineMessage(RowLine rowLine) {
        return BLANK.repeat(INTERVAL_WIDTH - 1) + VERTICAL_LINE
                + rowLine.getConnections().stream()
                .map(MessageResolver::findConnectionMark)
                .collect(Collectors.joining(VERTICAL_LINE))
                + VERTICAL_LINE;
    }

    private static String findConnectionMark(Connection connection) {
        if (connection == Connection.CONNECTED) {
            return CONNECT_MESSAGE;
        }
        return NOTCONNECT_MESSAGE;
    }
}
