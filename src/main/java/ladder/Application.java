package ladder;

import static ladder.view.InputView.readLadderHeight;
import static ladder.view.InputView.readPlayerNames;
import static ladder.view.InputView.readResults;
import static ladder.view.InputView.readTargetName;
import static ladder.view.OutputView.printLadder;
import static ladder.view.OutputView.printSingleResult;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.LadderFactory;
import ladder.domain.Players;
import ladder.domain.Results;
import ladder.domain.strategy.linestrategy.LineStrategy;
import ladder.domain.strategy.linestrategy.RandomLineStrategy;
import ladder.view.OutputView;

public class Application {
    private static final String QUIT = "q";
    private static final String ALL = "all";
    private static final Boolean END = false; // TODO: 그냥 false?
    private static final Boolean GO = true;

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

    private static boolean isQuit(String targetName) {
        if (targetName.equals(QUIT)) {
            return END;
        }
        return GO;
//        if (targetName.equals(QUIT)) {
//            return false;
//        }
//        return true;
    }

    private static boolean isAll(boolean flag, String input) {
        if (flag && input.equals(ALL)) {
            OutputView.printAllResult(players.getPlayersName(), results.findAllResult(ladder.getLines()));
            return END;
        }
        return GO;
//        if (flag && input.equals(ALL)) {
//            OutputView.printAllResult(players.getPlayersName(), results.findAllResult(ladder.getLines()));
//            return false;
//        }
//        return true;
    }

    private static void isSingleResult(boolean flag, String input) {
        if (flag) {
            printSingleResult(results.findResult(ladder.getLines(), players.findPosition(input)));
        }
    }
}
