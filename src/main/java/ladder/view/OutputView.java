package ladder.view;

import ladder.domain.LadderGame;

public class OutputView {
    public static void resultLadderTitle() {
        System.out.println("사다리 결과");
    }

    public static void resultLadder(LadderGame ladderGame) {
        System.out.println(ladderGame.toString());
    }

    public static void resultTitle() {
        System.out.println("실행 결과");
    }

    public static void resultPrint(String result) {
        System.out.println(result);
    }
}
