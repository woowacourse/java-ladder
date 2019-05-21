package ladder.model;

import ladder.model.coin.Half;

import java.util.List;

public class Game {
    private final Players players;
    private final Rewards rewards;
    private final Ladder ladder;


    public Game(List<String> playerNames, List<String> rewardNames, int height) {
        players = new Players(playerNames);
        rewards = new Rewards(players, rewardNames);
        ladder = new Ladder(players.number(), height, new Half());
    }

    public Players getPlayers() {
        return players;
    }

    public Rewards getRewards() {
        return rewards;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Result getResultOf(List<String> query) {
        return new Result(players, rewards, ladder, query);
    }
}