package laddergame.view;

import laddergame.dto.LadderResult;

public class OutputView {

    public void printResult(final LadderResult ladderResult) {
        System.out.println(
                "실행결과" + System.lineSeparator() +
                        NameFormatter.formatNames(ladderResult.names()) + System.lineSeparator() +
                        LadderFormatter.formatLadder(ladderResult)
        );
    }

    public void printExceptionMessage(final String message) {
        System.out.println(message);
    }
}
