package ladder.view;

import ladder.domain.ConnectionStatus;
import ladder.domain.Line;

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

    private static final String EXECUTION_MESSAGE = System.lineSeparator() + "실행결과" + System.lineSeparator();

    public static void printExecutionMessage() {
        System.out.println(EXECUTION_MESSAGE);
    }

    public static void printPlayerNames(List<String> names) {
        StringJoiner playerNames = new StringJoiner(NAME_DELIMITER);
        for (String name : names) {
            playerNames.add(formatWithSpace(name));
        }
        System.out.println(playerNames);
    }

    private static String formatWithSpace(String name) {
        int nameLength = name.length();
        int spaceAddCount = 5 - nameLength;

        return SPACE.repeat(spaceAddCount) + name;
    }

    public static void printLadder(List<Line> lines) {
        for (Line line : lines) {
            System.out.println(format(line));
        }
    }

    private static String format(Line line) {
        List<ConnectionStatus> lineStatus = line.getLineStatus();
        StringJoiner stringJoiner = new StringJoiner(LADDER_DELIMITER);
        stringJoiner.add(LINE_START_WITH);
        for (ConnectionStatus connectionStatus : lineStatus) {
            addUnitLine(stringJoiner, connectionStatus);
        }
        return stringJoiner + LINE_END_WITH;
    }

    private static void addUnitLine(StringJoiner stringJoiner, ConnectionStatus connectionStatus) {
        if (connectionStatus.equals(ConnectionStatus.CONNECTED)) {
            stringJoiner.add(CONNECTED_MARKER);
        }
        if (connectionStatus.equals(ConnectionStatus.DISCONNECTED)) {
            stringJoiner.add(DISCONNECTED_MARKER);
        }
    }
}
