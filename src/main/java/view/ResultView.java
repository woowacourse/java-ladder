package view;

import domain.Ladder;
import domain.LadderResult;
import domain.LadderResults;
import domain.Names;
import domain.Prizes;

public class ResultView {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    private final MessageResolver messageResolver;

    public ResultView(MessageResolver messageResolver) {
        this.messageResolver = messageResolver;
    }

    public void printLadder(Ladder ladder, Names names, Prizes prizes) {
        System.out.println(messageResolver.resolveLadderMessage(ladder, names, prizes));
    }

    public void printResult(LadderResult result) {
        System.out.println(messageResolver.resolveResultMessage(result));
    }

    public void printResults(LadderResults results) {
        System.out.println(messageResolver.resolveResultsMessage(results));
    }
}
