package view;

import domain.ladder.Ladder;
import domain.player.Players;
import domain.prize.Prizes;
import domain.result.LadderResult;
import domain.result.LadderResults;

public class ResultView {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    private final MessageResolver messageResolver;

    public ResultView(MessageResolver messageResolver) {
        this.messageResolver = messageResolver;
    }

    public void printLadder(Ladder ladder, Players players, Prizes prizes) {
        System.out.println(messageResolver.resolveLadderMessage(ladder, players, prizes));
    }

    public void printResult(LadderResult result) {
        System.out.println(messageResolver.resolveResultMessage(result));
    }

    public void printResults(LadderResults results) {
        System.out.println(messageResolver.resolveResultsMessage(results));
    }
}
