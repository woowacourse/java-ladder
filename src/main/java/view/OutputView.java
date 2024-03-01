package view;

import controller.dto.PrizeResult;
import controller.dto.PrizesResult;
import java.util.List;
import model.ladder.Line;

public class OutputView {
    private static final String LADDER_RESULT_FORMAT = "%s%n%n";
    private static final String LADDER_RESULT_MESSAGE = "사다리 결과";
    private static final String PRIZE_RESULT_MESSAGE = "실행 결과";

    private static final String PRIZES_RESULT_FORMAT = "%s : %s%n";

    public void printLadderResult(List<String> names, List<Line> lines, List<String> prizes) {
        System.out.printf(LADDER_RESULT_FORMAT, LADDER_RESULT_MESSAGE);
        printPlayers(names);
        printLadder(names.get(0).length(), lines);
        printPrizes(prizes);
    }

    private void printPlayers(List<String> names) {
        String value = Formatter.formatNames(names);
        System.out.println(value);
    }

    private void printLadder(int paddingSize, List<Line> lines) {
        String value = Formatter.formatLadder(paddingSize, lines);
        System.out.printf(value);
    }

    private void printPrizes(List<String> prizes) {
        String value = Formatter.formatNames(prizes);
        System.out.println(value);
    }

    public void printPrizeResult(final String name) {
        System.out.println();
        System.out.println(PRIZE_RESULT_MESSAGE);
        System.out.println(name);
    }

    public void printPrizesResult(final PrizesResult prizesResult) {
        System.out.println();
        System.out.println(PRIZE_RESULT_MESSAGE);
        for (PrizeResult prizeResult : prizesResult.results()) {
            System.out.printf(PRIZES_RESULT_FORMAT, prizeResult.name(), prizeResult.prize());
        }
    }
}
