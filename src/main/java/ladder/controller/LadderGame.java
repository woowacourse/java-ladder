package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Player;
import ladder.domain.Result;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private Ladder ladder;
    private List<Player> players;
    private List<String> rewards;

    public LadderGame() {
        players = inputNames();
        rewards = inputRewards();
        int height = InputView.getHeight();
        ladder = new Ladder(players.size(), height);
    }

    private List<Player> inputNames() {
        try {
            List<String> names = InputView.getNames();
            return getPlayers(names);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputNames();
        }
    }

    private List<String> inputRewards() {
        List<String> rewards = InputView.getRewards(players);

        boolean isOverLengthLimit = false;
        for (String reward : rewards) {
            isOverLengthLimit = isOverLengthLimit(isOverLengthLimit, reward);
        }

        if (isOverLengthLimit) {
            OutputView.printRewardErrorMsg();
            return inputRewards();
        }
        return rewards;
    }

    private boolean isOverLengthLimit(boolean isOverLengthLimit, String reward) {
        if (reward.length() > Player.MAX_NAME_LENGTH) {
            isOverLengthLimit = true;
        }
        return isOverLengthLimit;
    }

    private List<Player> getPlayers(List<String> names) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            players.add(new Player(names.get(i), i));
        }
        return players;
    }

    public void play() {
        printGame();
        ladder.goDown(players);
        Result result = new Result(players, rewards);
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
