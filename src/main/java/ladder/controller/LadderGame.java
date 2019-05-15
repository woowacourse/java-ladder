package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Player;
import ladder.domain.Result;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private static final int MAX_REWARD_LENGTH = Player.MAX_NAME_LENGTH;
    private static final int MIN_REWARD_LENGTH = Player.MIN_NAME_LENGTH;

    private final Ladder ladder;
    private final List<Player> players;
    private final List<String> rewards;

    public LadderGame() {
        players = makePlayers();
        rewards = inputRewards();
        ladder = new Ladder(players.size(), InputView.getHeight());
    }

    private List<Player> makePlayers() {
        try {
            return getPlayers(InputView.getNames());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return makePlayers();
        }
    }

    private List<Player> getPlayers(final List<String> names) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            players.add(new Player(names.get(i), i));
        }
        return players;
    }

    private List<String> inputRewards() {
        List<String> rewards = InputView.getRewards(players);
        boolean isOverLengthLimit = validateRewardsLength(rewards);
        if (isOverLengthLimit) {
            OutputView.printRewardErrorMsg();
            return inputRewards();
        }
        return rewards;
    }

    private static boolean validateRewardsLength(final List<String> rewards) {
        boolean isOverLengthLimit = false;
        for (String reward : rewards) {
            isOverLengthLimit = isOverLengthLimit(isOverLengthLimit, reward);
        }
        return isOverLengthLimit;
    }

    static boolean isOverLengthLimit(boolean isFound, final String reward) {
        if (reward.length() > MAX_REWARD_LENGTH || reward.length() < MIN_REWARD_LENGTH) {
            isFound = true;
        }
        return isFound;
    }

    public void play() {
        printGame();
        ladder.goDown(players);
        final Result result = new Result(players, rewards);
        String name;
        while (!(name = InputView.getName(players)).equals("all")) {
            OutputView.printResult(name, result);
        }
        OutputView.printResultAll(result);
    }

    private void printGame() {
        OutputView.printLadderMessage();
        OutputView.printNames(players);
        OutputView.printLadder(ladder);
        OutputView.printRewards(rewards);
    }


}
