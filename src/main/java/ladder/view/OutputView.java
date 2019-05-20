package ladder.view;

import static ladder.view.constants.OutputViewConstants.*;

public class OutputView {

    public static void printLadder(String ladderGame) {
        System.out.println(PAINT_LADDER_MESSAGE);
        System.out.println(ladderGame);
        System.out.println();
    }
    public static void printResult(String result) {
        System.out.println(PRINT_RESULT_MESSAGE);
        System.out.println(result);
        System.out.println();
    }

    public static void PrintMassage(String message) {
        System.out.println(message);
    }
}
