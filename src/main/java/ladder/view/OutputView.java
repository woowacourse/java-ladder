package ladder.view;

import ladder.model.LadderGame;

public class OutputView {
    private static final String LADDER_TITLE_MESSAGE = "사다리 결과";
    private static final String RESULT_TITLE_MESSAGE = "실행 결과";

    public static void resultLadderTitle() {
        System.out.println(LADDER_TITLE_MESSAGE);
    }

    public static void resultLadder(LadderGame ladderGame) {
        System.out.println(ladderGame.toString());
    }

    public static void resultTitle() {
        System.out.println(RESULT_TITLE_MESSAGE);
    }

    public static void resultPrint(String result) {
        System.out.println(result);
    }
}
