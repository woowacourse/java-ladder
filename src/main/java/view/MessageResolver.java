package view;

import domain.ConnectionStatus;
import domain.Ladder;
import domain.Names;
import domain.RowLine;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MessageResolver {
    private static final String COLUMN_LINE = "|";
    private static final String LINE_MESSAGE_PREFIX = "    ";
    private static final String CONNECT_STATUS_MESSAGE = "-----";
    private static final String DISCONNECT_STATUS_MESSAGE = "     ";

    public String resolveNamesMessage(Names names) {
        return names.getNames().stream()
                .map(name -> String.format("%-5s", name.getName()))
                .collect(Collectors.joining(" "));
    }

    public String resolveLadderMessage(Ladder ladder) {
        return IntStream.range(0, ladder.getRowLineCount())
                .mapToObj(ladder::getLineByIndex)
                .map(this::resolveLineMessage)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String resolveLineMessage(RowLine rowLine) {
        return LINE_MESSAGE_PREFIX + COLUMN_LINE + IntStream.range(0, rowLine.getConnectionCount())
                .mapToObj(rowLine::getConnection)
                .map(this::resolveConnectionMessage)
                .collect(Collectors.joining(COLUMN_LINE)) + COLUMN_LINE;
    }

    private String resolveConnectionMessage(ConnectionStatus connectionStatus) {
        if (connectionStatus.isConnect()) {
            return CONNECT_STATUS_MESSAGE;
        }
        return DISCONNECT_STATUS_MESSAGE;
    }
}
