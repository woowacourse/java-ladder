package ladder.view;

import java.util.List;
import ladder.domain.Bar;
import ladder.domain.Line;

public class OutputView {
    private static String startSpaces;

    private static final String WIDTH_SUFFIX = "|";
    private static final String MOVABLE_BAR = "|-----";
    private static final String IMMOVABLE_BAR = "|     ";
    private static final String BLANK = " ";
    private static final int DEFAULT_NAME_LENGTH = 6;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String LONGEST_START_SPACE = "    ";

    public static void printPlayers(List<String> playerNames) {
        setStartSpaces(playerNames.get(0).length());
        System.out.println();
        System.out.print(playerNames.get(0));
        for (int i = 1; i < playerNames.size(); i++) {
            printNameOnSquares(playerNames.get(i));
        }
        System.out.println();
    }

    private static void setStartSpaces(int nameLength) {
        if (nameLength == MAXIMUM_NAME_LENGTH) {
            startSpaces = LONGEST_START_SPACE;
            return;
        }
        startSpaces = BLANK.repeat(nameLength);
    }

    private static void printNameOnSquares(String playerName) {
        int nameLength = playerName.length();
        System.out.print(BLANK.repeat(DEFAULT_NAME_LENGTH - nameLength));
        System.out.print(playerName);
    }

    public static void printLadder(List<Line> lines) {
        for (Line line : lines) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        System.out.print(startSpaces);
        for (Bar bar : line.getBars()) {
            printBar(bar);
        }
        System.out.println(WIDTH_SUFFIX);
    }

    private static void printBar(Bar bar) {
        if (bar.isMovable()) {
            System.out.print(MOVABLE_BAR);
            return;
        }
        System.out.print(IMMOVABLE_BAR);
    }

    public static void announceExecution() {
        System.out.println();
        System.out.println("실행결과");
    }
}
