package ladder.view;

import static java.util.stream.Collectors.joining;

import java.util.List;
import ladder.domain.Line;
import ladder.domain.LineStatus;
import ladder.domain.Player;

public class OutputView {

    private static final int INITIAL_PLAYER_INDEX = 0;
    private static final int EMPTY_NAME_LENGTH = 0;
    private static final long SKIP_INITIAL_PLAYER = 1L;
    private static final String GAME_RESULT_MESSAGE = "\n실행결과";
    private static final String CONNECTED_SYMBOL = "-";
    private static final String EMPTY_SYMBOL = " ";
    private static final String NAME_MESSAGE_FORMAT = " %";
    private static final String STRING_FORMAT = "s";
    private static final String LINE_STATUS_MESSAGE_FORMAT = "%s|";
    private static final String NEXT_LINE = "\n";

    public void printResult(final List<Player> players, final List<Line> lines) {
        System.out.println(GAME_RESULT_MESSAGE);

        final int maxNameLength = calculateMaxNameLength(players);
        System.out.println(generateNameMessages(players, maxNameLength));

        final String initialPlayerName = findInitialPlayerName(players);
        System.out.println(generateLadderMessage(initialPlayerName.length(), maxNameLength, lines));
    }

    private int calculateMaxNameLength(final List<Player> players) {
        return players.stream()
                .map(Player::getName)
                .map(String::length)
                .max(Integer::compareTo)
                .orElse(EMPTY_NAME_LENGTH);
    }

    private String generateNameMessages(final List<Player> players, final int maxNameLength) {
        final String initialPlayerName = findInitialPlayerName(players) + EMPTY_SYMBOL;
        final String nameMessage = players.stream()
                .map(Player::getName)
                .skip(SKIP_INITIAL_PLAYER)
                .map(name -> generateNameMessage(name, maxNameLength))
                .collect(joining());
        return initialPlayerName + nameMessage;
    }

    private String generateNameMessage(final String name, int maxNameLength) {
        return String.format(NAME_MESSAGE_FORMAT + maxNameLength + STRING_FORMAT, name);
    }

    private String findInitialPlayerName(final List<Player> players) {
        return players.get(INITIAL_PLAYER_INDEX).getName();
    }

    private String generateLadderMessage(final int initialNameLength, final int maxNameLength, final List<Line> lines) {
        return NEXT_LINE + lines.stream()
                .map(line -> generateLineMessage(initialNameLength, maxNameLength, line))
                .collect(joining(NEXT_LINE));
    }

    private String generateLineMessage(final int initialNameLength, final int maxNameLength, final Line line) {
        final String initialMessage = generateRepeatedLineStatusMessage(CONNECTED_SYMBOL, initialNameLength);
        final String ladderMessage = line.getLine().stream()
                .map(lineStatus -> generateLineStatusMessage(maxNameLength, lineStatus))
                .collect(joining());
        return initialMessage + ladderMessage;
    }

    private String generateRepeatedLineStatusMessage(final String symbol, final int count) {
        return String.format(LINE_STATUS_MESSAGE_FORMAT, symbol.repeat(count));
    }

    private String generateLineStatusMessage(final int maxNameLength, final LineStatus lineStatus) {
        if (LineStatus.GO == lineStatus) {
            return generateRepeatedLineStatusMessage(CONNECTED_SYMBOL, maxNameLength);
        }
        return generateRepeatedLineStatusMessage(EMPTY_SYMBOL, maxNameLength);
    }
}
