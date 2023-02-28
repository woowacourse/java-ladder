package ladder.view;

import ladder.domain.ConnectionStatus;
import ladder.domain.Line;

import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;

public class ResultView {

    private static final String SPACE = " ";
    private static final String NAME_DELIMITER = " ";
    private static final String LADDER_DELIMITER = "|";
    private static final String LINE_START_WITH = "    ";
    private static final String LINE_END_WITH = "|";
    private static final String CONNECTED_MARKER = "-----";
    private static final String DISCONNECTED_MARKER = "     ";
    private static final String RESULT_DELIMITER = " ";
    private static final String GAME_RESULT_DELIMITER = " : ";

    private static final String EXECUTION_MESSAGE = System.lineSeparator() + "사다리 결과" + System.lineSeparator();

    public static void printExecutionMessage() {
        System.out.println(EXECUTION_MESSAGE);
    }

    public static void printPlayerNames(final List<String> names) {
        StringJoiner playerNames = new StringJoiner(NAME_DELIMITER);
        for (String name : names) {
            playerNames.add(formatWithSpace(name));
        }
        System.out.println(playerNames);
    }

    private static String formatWithSpace(final String name) {
        int nameLength = name.length();
        int spaceAddCount = 5 - nameLength;

        return SPACE.repeat(spaceAddCount) + name;
    }

    public static void printLadder(final List<Line> lines) {
        for (Line line : lines) {
            System.out.println(format(line));
        }
    }

    private static String format(final Line line) {
        List<ConnectionStatus> lineStatus = line.getLineStatus();
        StringJoiner stringJoiner = new StringJoiner(LADDER_DELIMITER);
        stringJoiner.add(LINE_START_WITH);
        for (ConnectionStatus connectionStatus : lineStatus) {
            addUnitLine(stringJoiner, connectionStatus);
        }
        return stringJoiner + LINE_END_WITH;
    }

    private static void addUnitLine(final StringJoiner stringJoiner, final ConnectionStatus connectionStatus) {
        if (connectionStatus.equals(ConnectionStatus.CONNECTED)) {
            stringJoiner.add(CONNECTED_MARKER);
        }
        if (connectionStatus.equals(ConnectionStatus.DISCONNECTED)) {
            stringJoiner.add(DISCONNECTED_MARKER);
        }
    }

    public static void printPrizes(final List<String> prizes) {
        StringJoiner gamePrizes = new StringJoiner(RESULT_DELIMITER);
        for (String prize : prizes) {
            gamePrizes.add(formatWithSpace(prize));
        }
        System.out.println(gamePrizes);
    }

    public static void printGameResult(final HashMap<String, String> result) {
        if (result.size() == 1) {
            printOnePlayerGameResult(result);
            return;
        }
        printManyPlayersGameResult(result);
    }

    private static void printManyPlayersGameResult(final HashMap<String, String> result) {
        StringBuilder gameResult = new StringBuilder();
        for (String playerName : result.keySet()) {
            StringJoiner eachGameResult = new StringJoiner(GAME_RESULT_DELIMITER);
            eachGameResult.add(playerName);
            eachGameResult.add(result.get(playerName));
            gameResult.append(eachGameResult + System.lineSeparator());
        }
        System.out.print(gameResult);
    }

    private static void printOnePlayerGameResult(final HashMap<String, String> result) {
        for (String playerName : result.keySet()) {
            System.out.println(result.get(playerName));
        }
    }
}
