package view;

import domain.LadderGame;
import domain.result.LadderResult;
import domain.result.LadderResults;

public class ResultView {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    private final MessageResolver messageResolver;

    public ResultView(MessageResolver messageResolver) {
        this.messageResolver = messageResolver;
    }

    public void printLadder(LadderGame ladderGame) {
        System.out.println(messageResolver.resolveLadderMessage(ladderGame));
    }

    public void printResult(LadderResult result) {
        System.out.println(messageResolver.resolveResultMessage(result));
    }

    public void printResults(LadderResults results) {
        System.out.println(messageResolver.resolveResultsMessage(results));
    }
}
