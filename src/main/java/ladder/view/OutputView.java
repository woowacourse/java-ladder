package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;

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

    public static void printPlayersName(List<String> playersName) {
        for (String name: playersName) {
            System.out.print(name + " ");
        }
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();

        for (Line line : lines) {
            printOneLine(line);
            System.out.println();
        }
    }

    private static void printOneLine(Line line) {
        printLadderFrame();
        for (Boolean block : line.getBlocks()) {
            printBlock(block);
            printLadderFrame();
        }
    }

    private static void printBlock(Boolean block) {
        if (block) {
            System.out.print(LADDER_BLOCK);
            return;
        }
        System.out.print(LADDER_EMPTY_BLOCK);
    }

    private static void printLadderFrame() {
        System.out.print(LADDER_FRAME);
    }
}
