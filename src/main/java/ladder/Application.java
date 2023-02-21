package ladder;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.LadderFactory;
import ladder.domain.Players;
import ladder.domain.Results;
import ladder.domain.strategy.linestrategy.LineStrategy;
import ladder.domain.strategy.linestrategy.RandomLineStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Players players = new Players(InputView.readPlayerNames());
        Results results = new Results(InputView.readResults(), players.getPlayersCount());
        Height height = new Height(InputView.readLadderHeight());
        LineStrategy lineStrategy = new RandomLineStrategy();

        LadderFactory ladderFactory = new LadderFactory(height, players, lineStrategy);
        Ladder ladder = ladderFactory.makeLadder();

        OutputView.printLadder(players.getPlayers(), ladder.getLines(), results.getResults());

        while (true) {
            String targetName = InputView.readTargetName();
            if (targetName.equals("q")) {
                break;
            }
            if (targetName.equals("all")) {
                OutputView.printAllResult(players.getPlayerNames(), results.findAllResult(ladder.getLines()));
                break;
            }
            OutputView.printSingleResult(results.findResult(ladder.getLines(), players.findPosition(targetName)));
        }
    }
}
