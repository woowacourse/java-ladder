package ladder.view;

import java.util.List;
import java.util.StringJoiner;

import ladder.domain.*;

public class OutputView {

    private static final String EXECUTION_RESULT = "실행결과";
    private static final String LINE_BREAK = "\n";
    private static final String FOOTHOLD = "-----";
    private static final String BLANK_FOOTHOLD = "     ";
    private static final int FORMAT_LENGTH = 5;
    private static final String RIGHT_ALIGN = "%" + FORMAT_LENGTH + "s";
    private static final String BLANK = " ";
    private static final String EMPTY = "";
    private static final String LADDER = "|";
    private static final String DELIMITER = " : ";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printLadderResult(final Players players, final Ladder ladder, final Gifts gifts) {
        System.out.println(EXECUTION_RESULT + LINE_BREAK);
        printPlayerNames(players);
        printLadder(ladder);
        printGiftNames(gifts);
    }

    private void printPlayerNames(final Players players) {
        final List<String> playerNames = players.getPlayerNames();
        System.out.println(getFormattedNames(playerNames));
    }

    private String getFormattedNames(final List<String> playerNames) {
        final StringJoiner joiner = new StringJoiner(BLANK);

        for (final String playerName : playerNames) {
            joiner.add(String.format(RIGHT_ALIGN, playerName));
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
            stringJoiner.add(getFoothold(direction));
        }

        System.out.println(stringJoiner);
    }

    private String getFoothold(final Direction direction) {
        if (direction.equals(Direction.LEFT)) {
            return FOOTHOLD;
        }

        return BLANK_FOOTHOLD;
    }

    private void printGiftNames(Gifts gifts) {
        final List<String> giftNames = gifts.getNames();
        System.out.println(getFormattedNames(giftNames));
    }

    public void printErrorMessage(final IllegalArgumentException e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }

    public void printGameResult(Players players, Gifts gifts, Result result) {
        System.out.println(EXECUTION_RESULT);
        for (final String name : result.getNames()) {
            System.out.println(name + DELIMITER + gifts.findNameByPosition(players.findPositionByName(name)));
        }
    }
}
