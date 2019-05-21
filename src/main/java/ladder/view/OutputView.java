package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.LadderGameData;

public class OutputView {
    private static final String LADDER_RESULT_MESSAGE = "사다리 결과";
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";

    public static void printLadder(LadderGame ladderGame, LadderGameData ladderGameData) {
        System.out.println(LADDER_RESULT_MESSAGE);
        System.out.println(ladderGameData.getPerson());
        System.out.println(ladderGame);
        System.out.println(ladderGameData.getResult());
    }

    public static void printLadderResult(String ladderResult) {
        System.out.println("\n" + EXECUTION_RESULT_MESSAGE);
        System.out.println(ladderResult + "\n");
    }
}
