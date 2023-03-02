package ladder.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String LADDER_RESULT_HEADER_MESSAGE = "사다리 결과";
    private static final String PLAYER_RESULT_HEADER_MESSAGE = "실행 결과";
    private static final String BLANK = "\n";
    private static final String LADDER_FRAME = "|";
    private static final String LADDER_BLOCK = "-----";
    private static final String LADDER_EMPTY_BLOCK = "     ";
    private static final String DELIMITER = " : ";

    public static void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printGameResultHeader() {
        System.out.println();
        System.out.println(LADDER_RESULT_HEADER_MESSAGE);
        System.out.println();
    }

    public static void printPlayersName(final List<String> playersName) {
        printNames(playersName);
    }

    public static void printPrizesName(final List<String> prizesName) {
        printNames(prizesName);
        System.out.println();
    }

    private static void printNames(final List<String> names) {
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println();
    }

    public static void printLadder(final List<List<Boolean>> lines) {
        for (List<Boolean> line : lines) {
            printOneLine(line);
            System.out.println();
        }
    }

    private static void printOneLine(final List<Boolean> blocks) {
        printLadderFrame();
        for (Boolean block : blocks) {
            printBlock(block);
            printLadderFrame();
        }
    }

    private static void printBlock(final Boolean blockValue) {
        if (blockValue) {
            System.out.print(LADDER_BLOCK);
            return;
        }
        System.out.print(LADDER_EMPTY_BLOCK);
    }

    private static void printLadderFrame() {
        System.out.print(LADDER_FRAME);
    }

    public static void printPlayerResultHeaderMessage() {
        System.out.println(BLANK + PLAYER_RESULT_HEADER_MESSAGE);
    }

    public static void printAllResults(final Map<String, String> results) {
        for (String playerName : results.keySet()) {
            System.out.println(playerName + DELIMITER + results.get(playerName));
        }
    }

    public static void printSingleResult(final String prizeName) {
        System.out.println(prizeName);
    }
}
