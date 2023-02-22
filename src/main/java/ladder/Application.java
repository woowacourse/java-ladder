package ladder;

import static ladder.view.InputView.readLadderHeight;
import static ladder.view.InputView.readPlayerNames;
import static ladder.view.InputView.readResults;
import static ladder.view.InputView.readTargetName;
import static ladder.view.OutputView.printAllResult;
import static ladder.view.OutputView.printLadder;
import static ladder.view.OutputView.printSingleResult;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.LadderFactory;
import ladder.domain.Players;
import ladder.domain.Results;
import ladder.domain.strategy.linestrategy.LineStrategy;
import ladder.domain.strategy.linestrategy.RandomLineStrategy;

public class Application {
    private static final String QUIT = "q";
    private static final String ALL = "all";
    private static final Boolean FINISH = false; // TODO: 그냥 false?
    private static final Boolean PROCEED = true;

    private static Players players;
    private static Results results;
    private static Height height;
    private static final LineStrategy lineStrategy = new RandomLineStrategy();
    private static LadderFactory ladderFactory;
    private static Ladder ladder;

    public static void main(String[] args) {
        players = new Players(readPlayerNames());
        results = new Results(readResults(), players.getPlayersCount());
        height = new Height(readLadderHeight());

        ladderFactory = new LadderFactory(height, players, lineStrategy);
        ladder = ladderFactory.makeLadder();
        printLadder(players.getPlayers(), ladder.getLines(), results.getResults());

        askResult();
    }

    private static void askResult() {
        boolean proceed = true;
        while (proceed) {
            String input = readTargetName();
            proceed = isQuit(input);
            proceed = isAll(proceed, input);
            isSingleResult(proceed, input);
        }
    }

    private static boolean isQuit(String input) {
        if (input.equals(QUIT)) {
            return FINISH;
        }
        return PROCEED;
    }

    private static boolean isAll(boolean proceed, String input) {
        if (proceed && input.equals(ALL)) {
            printAllResult(players.getPlayersName(), results.findAllResult(ladder.getLines()));
            return FINISH;
        }
        return PROCEED;
    }

    private static void isSingleResult(boolean proceed, String playerName) {
        if (proceed) {
            printSingleResult(results.findResult(ladder.getLines(), players.findPosition(playerName)));
        }
    }
}
