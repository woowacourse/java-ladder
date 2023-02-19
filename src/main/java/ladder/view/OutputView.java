package ladder.view;

import java.util.List;

public class OutputView {

    private static final String GAME_RESULT_HEADER_MESSAGE = "실행 결과";
    private static final String LADDER_FRAME = "|";
    private static final String LADDER_BLOCK = "-----";
    private static final String LADDER_EMPTY_BLOCK = "     ";

    public static void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printGameResultHeader() {
        System.out.println();
        System.out.println(GAME_RESULT_HEADER_MESSAGE);
        System.out.println();
    }

    public static void printPlayersName(final List<String> playersName) {
        for (String name : playersName) {
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
}
