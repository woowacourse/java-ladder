package view;

import domain.ConnectionStatus;
import domain.Ladder;
import domain.line.RowLine;
import domain.name.Names;

import java.util.stream.Collectors;

public class ResultView {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String COLUMN_LINE = "|";
    private static final String NAME_FORMAT = "%-5s";
    private static final String BLANK = " ";
    private static final String ROW_LINE = "-----";
    private static final String EMPTY_LINE = "     ";

    public void printLadder(Ladder ladder, Names names) {
        System.out.println(LINE_SEPARATOR + "실행결과" + LINE_SEPARATOR);
        System.out.println(resolveNamesMessage(names));
        System.out.println(resolveLadderMessage(ladder));
    }

    private String resolveNamesMessage(Names names) {
        return names.getNames().stream()
                .map(name -> String.format(NAME_FORMAT, name.getName()))
                .collect(Collectors.joining(BLANK));
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
            return ROW_LINE;
        }
        return EMPTY_LINE;
    }
}
