package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;
    private final Rewards rewards;

    public LadderGame() {
        players = makePlayers();
        rewards = makeRewards();
        ladder = new Ladder(players.getPlayerSize(), InputView.getHeight());
    }

    private Players makePlayers() {
        try {
            return new Players(InputView.getNames());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return makePlayers();
        }
    }

    private Rewards makeRewards() {
        try {
            List<String> rewardsInput = InputView.getRewards();
            validatePlayerRewardLength(rewardsInput.size());
            return new Rewards(rewardsInput);
        } catch (IllegalArgumentException e) {
            OutputView.printRewardErrorMsg();
            return makeRewards();
        }
    }

    private void validatePlayerRewardLength(int size) {
        if (!players.hasSameSize(size))
            throw new IllegalArgumentException();
    }

    public ResultPairs play() {
        printGame();
        final ResultIndex result = ladder.goDown();
        return new ResultPairs(players, rewards, result);
    }

    private void printGame() {
        OutputView.printLadderMessage();
        OutputView.printNames(players);
        OutputView.printLadder(ladder);
        OutputView.printRewards(rewards);
    }
}