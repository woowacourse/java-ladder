package ladder.view;

import static java.text.MessageFormat.format;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import ladder.domain.Direction;
import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.domain.Line;
import ladder.domain.Players;
import ladder.domain.Prizes;

public class OutputView {

    private static final String LINE_BREAK = System.lineSeparator();
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String LADDER = "|";
    private static final String FOOTHOLD = "-----";
    private static final String EMPTY_FOOTHOLD = "     ";

    public void printLadderGame(final Players players, final Ladder ladder, final Prizes prizes) {
        System.out.println(LINE_BREAK + "사다리 결과" + LINE_BREAK);
        printPlayerNames(players);
        printLadder(ladder);
        printPrizeNames(prizes);
        System.out.println();
    }

    private void printPlayerNames(final Players players) {
        final List<String> playerNames = players.getPlayerNames();
        System.out.println(getFormattedNames(playerNames));
    }

    private String getFormattedNames(final List<String> names) {
        final StringJoiner joiner = new StringJoiner(" ");

        for (final String name : names) {
            joiner.add(String.format("%5s", name));
        }

        return joiner.toString();
    }

    private void printLadder(final Ladder ladder) {
        final List<Line> lines = ladder.getLines();

        for (final Line line : lines) {
            System.out.println(getFormattedLine(line));
        }
    }

    private String getFormattedLine(final Line line) {
        final List<Direction> directions = line.getDirections();
        final StringJoiner joiner = new StringJoiner(LADDER, "", LADDER);

        for (final Direction direction : directions) {
            joiner.add(drawFootHold(direction));
        }

        return joiner.toString();
    }

    private String drawFootHold(final Direction direction) {
        if (direction.getFootholdStatus()) {
            return FOOTHOLD;
        }
        return EMPTY_FOOTHOLD;
    }

    private void printPrizeNames(final Prizes prizes) {
        final List<String> resultNames = prizes.getPrizeNames();
        System.out.println(getFormattedNames(resultNames));
    }

    public void printResult(final LadderResult ladderResult) {
        System.out.println(LINE_BREAK + EXECUTION_RESULT);
        final Map<String, String> value = ladderResult.getValue();
        for (final String key : value.keySet()) {
            System.out.println(format("{0} : {1}", key, value.get(key)));
        }
    }

    public void printResult(final String result) {
        System.out.println(LINE_BREAK + EXECUTION_RESULT);
        System.out.println(result);
    }

    public void printErrorMessage(final String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }
}
