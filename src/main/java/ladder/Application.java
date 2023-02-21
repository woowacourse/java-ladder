package ladder;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.LadderFactory;
import ladder.domain.Players;
import ladder.domain.strategy.linestrategy.LineStrategy;
import ladder.domain.strategy.linestrategy.RandomLineStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Players players = new Players(InputView.readPlayerNames());
        Height height = new Height(InputView.readLadderHeight());
        LineStrategy lineStrategy = new RandomLineStrategy();

        LadderFactory ladderFactory = new LadderFactory(height, players, lineStrategy);
        Ladder ladder = ladderFactory.makeLadder();
        OutputView.printResult(players.getPlayers(), ladder.getLines());
    }
}
