package view;

import domain.ConnectionStatus;
import domain.Ladder;
import domain.Names;
import domain.RowLine;
import java.util.stream.Collectors;

public class MessageResolver {
    private static final String COLUMN_LINE = "|";

    public String resolveNamesMessage(Names names) {
        return names.getNames().stream()
                .map(name -> String.format("%-5s", name.getName()))
                .collect(Collectors.joining(" "));
    }

    public String resolveLadderMessage(Ladder ladder) {
        return ladder.getLines().stream()
                .map(this::resolveLineMessage)
                .collect(Collectors.joining(System.lineSeparator()));

    }

    private String resolveLineMessage(RowLine rowLine) {
        return "    " + COLUMN_LINE + rowLine.getConnections().stream()
                .map(this::resolveConnectionMessage)
                .collect(Collectors.joining(COLUMN_LINE)) + COLUMN_LINE;
    }

    private String resolveConnectionMessage(ConnectionStatus connectionStatus) {
        if (connectionStatus.isConnect()) {
            return "-----";
        }
        return "     ";
    }
}
