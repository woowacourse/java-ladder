package view;

import domain.ConnectionStatus;
import domain.Ladder;
import domain.LadderResult;
import domain.LadderResults;
import domain.Names;
import domain.Prizes;
import domain.RowLine;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MessageResolver {

    private static final String COLUMN_LINE = "|";
    private static final String LINE_MESSAGE_PREFIX = "    ";
    private static final String CONNECT_STATUS_MESSAGE = "-----";
    private static final String DISCONNECT_STATUS_MESSAGE = "     ";
    private static final String LADDER_RESULT_PREFIX = "실행 결과" + System.lineSeparator();
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String LADDER_MESSAGE_PREFIX = LINE_SEPARATOR + "사다리결과" + LINE_SEPARATOR;

    public String resolveResultMessage(LadderResult ladderResult) {
        return LADDER_RESULT_PREFIX + ladderResult.getResult();
    }

    public String resolveResultsMessage(LadderResults results) {
        return LADDER_RESULT_PREFIX + results.getResults().stream()
                .map(result -> String.format("%s : %s", result.getName(), result.getResult()))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public String resolveLadderMessage(Ladder ladder, Names names, Prizes prizes) {
        return LADDER_MESSAGE_PREFIX + LINE_SEPARATOR
                + this.resolveNamesMessage(names) + LINE_SEPARATOR
                + this.resolveLadderShapeMessage(ladder) + LINE_SEPARATOR
                + this.resolvePrizesMessage(prizes);
    }

    private String resolveNamesMessage(Names names) {
        return names.getNames().stream()
                .map(name -> String.format("%-5s", name.getName()))
                .collect(Collectors.joining(" "));
    }

    private String resolvePrizesMessage(Prizes prizes) {
        return prizes.getPrizes().stream()
                .map(prize -> String.format("%-5s", prize.getPrize()))
                .collect(Collectors.joining(" "));
    }

    private String resolveLadderShapeMessage(Ladder ladder) {
        return IntStream.range(0, ladder.getRowLineCount())
                .mapToObj(ladder::getLineByIndex)
                .map(this::resolveLineMessage)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String resolveLineMessage(RowLine rowLine) {
        return LINE_MESSAGE_PREFIX + COLUMN_LINE + IntStream.range(0, rowLine.getConnectionCount())
                .mapToObj(rowLine::getRightConnection)
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
