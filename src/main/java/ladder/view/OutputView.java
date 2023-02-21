package ladder.view;

import java.util.List;
import java.util.StringJoiner;
import ladder.domain.Direction;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Players;
import ladder.domain.Prizes;

public class OutputView {

    private static final String LINE_BREAK = "\n";
    private static final int FORMAT_LENGTH = 5;
    private static final String RIGHT_ALIGN = "%" + FORMAT_LENGTH + "s";
    private static final String BLANK = " ";
    private static final String EMPTY = "";
    private static final String LADDER = "|";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printLadderResult(final Players players, final Ladder ladder, final Prizes prizes) {
        System.out.println(LINE_BREAK + "사다리 결과" + LINE_BREAK);
        printPlayerNames(players);
        printLadder(ladder);
        printResultNames(prizes);
        System.out.println();
    }

    private void printPlayerNames(final Players players) {
        final List<String> playerNames = players.getPlayerNames();
        System.out.println(getFormattedNames(playerNames));
    }

    private String getFormattedNames(final List<String> names) {
        final StringJoiner joiner = new StringJoiner(BLANK);

        for (final String name : names) {
            joiner.add(String.format(RIGHT_ALIGN, name));
        }

        return joiner.toString();
    }

    private void printLadder(final Ladder ladder) {
        final List<Line> lines = ladder.getLines();

        for (final Line line : lines) {
            printLine(line);
        }
    }

    private void printLine(final Line line) {
        final List<Direction> directions = line.getDirections();
        final StringJoiner stringJoiner = new StringJoiner(LADDER, EMPTY, LADDER);

        for (final Direction direction : directions) {
            stringJoiner.add(direction.getFoothold());
        }

        System.out.println(stringJoiner);
    }

    private void printResultNames(final Prizes prizes) {
        final List<String> resultNames = prizes.getResultNames();
        System.out.println(getFormattedNames(resultNames));
    }

    public void printErrorMessage(final String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }
}
