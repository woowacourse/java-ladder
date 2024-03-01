package view;

import static domain.connection.Connection.RIGHT_CONNECTION;

import domain.ColumnPosition;
import domain.connection.Connection;
import domain.ladder.Ladder;
import domain.line.Point;
import domain.line.RowLine;
import domain.player.Players;
import domain.prize.Prizes;
import domain.result.LadderResult;
import domain.result.LadderResults;
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
        return LINE_SEPARATOR + LADDER_RESULT_PREFIX + ladderResult.getResult();
    }

    public String resolveResultsMessage(LadderResults results) {
        return LINE_SEPARATOR + LADDER_RESULT_PREFIX + results.getResults().stream()
                .map(result -> String.format("%s : %s", result.getName(), result.getResult()))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public String resolveLadderMessage(Ladder ladder, Players players, Prizes prizes) {
        return LADDER_MESSAGE_PREFIX + LINE_SEPARATOR
                + this.resolveNamesMessage(players) + LINE_SEPARATOR
                + this.resolveLadderShapeMessage(ladder) + LINE_SEPARATOR
                + this.resolvePrizesMessage(prizes);
    }

    private String resolveNamesMessage(Players players) {
        return players.getPlayers().stream()
                .map(player -> String.format("%-5s", player.getPlayerName().getName()))
                .collect(Collectors.joining(" "));
    }

    private String resolvePrizesMessage(Prizes prizes) {
        return prizes.getPrizes().stream()
                .map(prize -> String.format("%-5s", prize.getPrizeName()))
                .collect(Collectors.joining(" "));
    }

    private String resolveLadderShapeMessage(Ladder ladder) {
        return IntStream.range(0, ladder.getRowLineCount())
                .mapToObj(ladder::getLineByIndex)
                .map(this::resolveLineMessage)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String resolveLineMessage(RowLine rowLine) {
        return LINE_MESSAGE_PREFIX + COLUMN_LINE + IntStream.range(0, rowLine.getPointCount() - 1)
                .mapToObj(i -> rowLine.getPointAt(new ColumnPosition(i)))
                .map(Point::getConnection)
                .map(this::resolveConnectionMessage)
                .collect(Collectors.joining(COLUMN_LINE)) + COLUMN_LINE;
    }

    private String resolveConnectionMessage(Connection connection) {
        if (connection.equals(RIGHT_CONNECTION)) {
            return CONNECT_STATUS_MESSAGE;
        }
        return DISCONNECT_STATUS_MESSAGE;
    }
}
