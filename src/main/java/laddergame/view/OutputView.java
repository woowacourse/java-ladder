package laddergame.view;

import static laddergame.messsages.ViewMessages.ANNOUNCE_RESULT;

public class OutputView {
    public void printResult(final String ladderFrom) {
        System.out.println(ANNOUNCE_RESULT.getMessage());
        System.out.println(ladderFrom);
    }
}
