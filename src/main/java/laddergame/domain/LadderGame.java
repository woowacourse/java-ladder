package laddergame.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    private Players players;
    private Rewards rewards;
    private Ladder ladder;
    private final Map<String, Reward> result = new HashMap<>();

    public LadderGame(Players players, Rewards rewards, Ladder ladder) {
        this.players = players;
        this.rewards = rewards;
        this.ladder = ladder;
    }

    public void start() {
        players.rideLadder(ladder.getLines());
        matchPlayerAndReward(players, rewards);
    }

    public Reward getReward(String playerName) {
        return result.get(playerName);
    }

    private void matchPlayerAndReward(Players players, Rewards rewards) {
        for (Player player : players.getPlayers()) {
            result.put(player.getName(), rewards.getRewards().get(player.getPosition()));
        }
    }
}
