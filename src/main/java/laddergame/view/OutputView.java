package laddergame.view;

import laddergame.domain.Result;

public class OutputView {

    public void printResult(final Result result) {
        System.out.println(
                "실행결과" + System.lineSeparator() +
                        NameFormatter.formatNames(result.names()) + System.lineSeparator() +
                        LadderFormatter.formatLadder(result)
        );
    }

    public void printExceptionMessage(final String message) {
        System.out.println(message);
    }
}
