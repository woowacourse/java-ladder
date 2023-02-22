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
        int index = players.findIndexByName(name);
        int result = ladder.move(index);
        return new Result(name.getName(), rewards.getReward(result).getName());
    }

    public List<Result> getResults() {
        List<Result> results = new ArrayList<>();

        for (int i = 0; i < players.getNumberOfPlayer(); i++) {
            int result = ladder.move(i);
            results.add(new Result(players.findNameByIndex(i), rewards.getReward(result).getName()));
        }

        return results;
    }
}
