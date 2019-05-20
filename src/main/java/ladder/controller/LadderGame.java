package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderGame {
    private static final String ALL = "all";

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

    public void play() {
        printGame();
        List<Integer> resultIndex = ladder.goDown();
        final Result result = new Result(players, rewards, resultIndex);
        String name;
        while (!(name = InputView.getName()).equals(ALL)) {
            printResultWithName(result, name);
        }
        OutputView.printResultAll(result.toString());
    }

    private void printResultWithName(Result result, String name) {
        if (result.hasName(name)) {
            OutputView.printResult(result.getReward(name));
            return;
        }
        OutputView.printResultErrorMsg();
    }

    private void printGame() {
        OutputView.printLadderMessage();
        OutputView.printNames(players);
        OutputView.printLadder(ladder);
        OutputView.printRewards(rewards);
    }
}