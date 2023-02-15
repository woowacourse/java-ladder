package ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.Line;
import ladder.domain.LineStatus;
import ladder.domain.Player;

public class OutputView {

    private static final String GAME_RESULT_MESSAGE = "\n실행결과";
    private static final String CONNECTED_SYMBOL = "-";
    private static final String EMPTY_SYMBOL = " ";
    private static final String NAME_MESSAGE_FORMAT = " %";
    private static final String STRING_FORMAT = "s";
    private static final String LINE_STATUS_MESSAGE_FORMAT = "%s|";
    private static final String NEXT_LINE = "\n";

    public void printResult(final List<Player> players, final List<Line> lines) {
        final int initLength = initPlayerNameLength(players.get(0));
        final int length = calculateMaxLength(players);

        System.out.println(GAME_RESULT_MESSAGE);
        System.out.print(players.get(0).getName() + EMPTY_SYMBOL);

        players.stream()
                .map(Player::getName)
                .skip(1L)
                .forEach(name -> generateNameMessage(name, length));

        System.out.println(NEXT_LINE + generateLadderMessage(initLength, length, lines));
    }

    private void generateNameMessage(final String name, int maxNameLength) {
        System.out.print(String.format(NAME_MESSAGE_FORMAT + maxNameLength + STRING_FORMAT, name));
    }

    private int initPlayerNameLength(final Player player) {
        return player.getName().length();
    }

    private int calculateMaxLength(final List<Player> players) {
        return players.stream()
                .mapToInt(player -> player.getName().length())
                .max()
                .getAsInt();
    }

    private String generateLadderMessage(final int initLength, final int length, final List<Line> lines) {
        return lines.stream()
                .map(line -> generateLineMessage(initLength, length, line))
                .collect(Collectors.joining(NEXT_LINE));
    }

    private String generateLineMessage(final int initLength, final int length, final Line line) {
        final String startMessage = String.format(LINE_STATUS_MESSAGE_FORMAT, EMPTY_SYMBOL.repeat(initLength));
        final String ladderMessage = line.getLine().stream()
                .map(lineStatus -> generateLineStatusMessage(length, lineStatus))
                .collect(Collectors.joining());
        return startMessage + ladderMessage;
    }

    private String generateLineStatusMessage(final int length, final LineStatus lineStatus) {
        if (LineStatus.GO == lineStatus) {
            return String.format(LINE_STATUS_MESSAGE_FORMAT, CONNECTED_SYMBOL.repeat(length));
        }
        return String.format(LINE_STATUS_MESSAGE_FORMAT, EMPTY_SYMBOL.repeat(length));
    }
}
