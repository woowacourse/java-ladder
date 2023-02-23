package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private final Ladder ladder;
    private final Players players;
    private final Rewards rewards;

    public LadderGame(final Ladder ladder, final Players players, final Rewards rewards) {
        this.ladder = ladder;
        this.players = players;
        this.rewards = rewards;
    }

    public Result getResult(final Name name) {
        int playerIndex = players.findIndexByName(name);
        int rewardIndex = ladder.move(playerIndex);
        return new Result(rewards.getRewardName(rewardIndex));
    }

    public Results getResults() {
        List<Result> results = new ArrayList<>();

        for (int i = 0; i < players.getNumberOfPlayer(); i++) {
            int rewardIndex = ladder.move(i);
            Result result = new Result(players.getPlayerName(i), rewards.getRewardName(rewardIndex));
            results.add(result);
        }

        return new Results(results);
    }
}
