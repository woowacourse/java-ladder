package ladder.view;

import ladder.domain.ConnectionStatus;
import ladder.domain.Line;
import ladder.domain.ResultDto;

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

    public static void printResults(final List<String> results) {
        StringJoiner ExecutionResult = new StringJoiner(RESULT_DELIMITER);
        for (String result : results) {
            ExecutionResult.add(formatWithSpace(result));
        }
        System.out.println(ExecutionResult);
    }

    public static void printGameResult(final ResultDto resultDto) {
        if (resultDto.getPlayerNames().size() == 1) {
            printOnePlayerGameResult(resultDto);
            return;
        }
        printManyPlayersGameResult(resultDto);
    }

    private static void printManyPlayersGameResult(final ResultDto resultDto) {
        StringBuilder gameResult = new StringBuilder();
        for (int index = 0; index < resultDto.getPlayerNames().size(); index++) {
            StringJoiner eachGameResult = new StringJoiner(GAME_RESULT_DELIMITER);
            eachGameResult.add(resultDto.getPlayerNames().get(index));
            eachGameResult.add(resultDto.getGameResult().get(index));
            gameResult.append(eachGameResult + System.lineSeparator());
        }
        System.out.print(gameResult);
    }

    private static void printOnePlayerGameResult(final ResultDto resultDto) {
        System.out.println(resultDto.getGameResult().get(0));
    }
}
