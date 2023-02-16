package ladder.view;

import static java.util.stream.Collectors.joining;

import java.util.List;
import ladder.domain.Line;
import ladder.domain.LineStatus;

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
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public void printResult(final List<String> players, final List<Line> ladder) {
        System.out.println(GAME_RESULT_MESSAGE);

        final int maxNameLength = calculateMaxNameLength(players);
        System.out.println(generateNameMessages(players, maxNameLength));

        final String initialPlayerName = findInitialPlayerName(players);
        System.out.println(generateLadderMessage(initialPlayerName.length(), maxNameLength, ladder));
    }

    private int calculateMaxNameLength(final List<String> players) {
        return players.stream()
                .map(String::length)
                .max(Integer::compareTo)
                .orElse(EMPTY_NAME_LENGTH);
    }

    private String generateNameMessages(final List<String> players, final int maxNameLength) {
        final String initialPlayerName = findInitialPlayerName(players) + EMPTY_SYMBOL;
        final String nameMessage = players.stream()
                .skip(SKIP_INITIAL_PLAYER)
                .map(name -> generateNameMessage(name, maxNameLength))
                .collect(joining());
        return NEXT_LINE + initialPlayerName + nameMessage;
    }

    private String generateNameMessage(final String name, int maxNameLength) {
        return String.format(NAME_MESSAGE_FORMAT + maxNameLength + STRING_FORMAT, name);
    }

    private String findInitialPlayerName(final List<String> players) {
        return players.get(INITIAL_PLAYER_INDEX);
    }

    private String generateLadderMessage(final int initialNameLength, final int maxNameLength, final List<Line> lines) {
        return lines.stream()
                .map(line -> generateLineMessage(initialNameLength, maxNameLength, line))
                .collect(joining(NEXT_LINE));
    }

    private String generateLineMessage(final int initialNameLength, final int maxNameLength, final Line line) {
        final String initialMessage = generateRepeatedLineStatusMessage(EMPTY_SYMBOL, initialNameLength);
        final String ladderMessage = line.getLine().stream()
                .map(lineStatus -> generateLineStatusMessage(maxNameLength, lineStatus))
                .collect(joining());
        return initialMessage + ladderMessage;
    }

    private String generateRepeatedLineStatusMessage(final String symbol, final int count) {
        return String.format(LINE_STATUS_MESSAGE_FORMAT, symbol.repeat(count));
    }

    private String generateLineStatusMessage(final int maxNameLength, final LineStatus lineStatus) {
        if (lineStatus.isConnected()) {
            return generateRepeatedLineStatusMessage(CONNECTED_SYMBOL, maxNameLength);
        }
        return generateRepeatedLineStatusMessage(EMPTY_SYMBOL, maxNameLength);
    }

    public void printError(final String message) {
        System.out.println(ERROR_MESSAGE + message);
    }
}
