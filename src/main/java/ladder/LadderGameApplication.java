package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameApplication {
    public static void main(String[] args) {
        Players players = InputView.createPlayers();
        Rewards rewards = InputView.createRewards(players.getPlayerSize());
        Ladder ladder = new Ladder(players.getPlayerSize(), InputView.getHeight());

        OutputView.printLadder(players, rewards, ladder);

        ResultPairs resultPairs = new ResultPairs(players, rewards, ladder.goDown());
        OutputView.printResult(resultPairs);
    }
}