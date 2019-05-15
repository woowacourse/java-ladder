package ladder.view;

import ladder.domain.LadderGame;

public class OutputView {
    public static void resultTitle() {
        System.out.println("실행결과");
    }

    public static void resultLadder(LadderGame ladderGame) {
        System.out.println(ladderGame.toString());
    }
}
