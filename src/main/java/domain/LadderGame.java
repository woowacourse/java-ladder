package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {

    private final Ladder ladder;
    private final Players players;
    private final Rewards rewards;

    public LadderGame(final Ladder ladder, final Players players, final Rewards rewards) {
        this.ladder = ladder;
        this.players = players;
        this.rewards = rewards;
    }

    public Map<String, String> getReward(final Name name) {
        if (name.getName().equals("all")) {
            return getAllReward();
        }

        int index = players.findIndexByName(name);
        int result = ladder.move(index);
        return Map.of(name.getName(), rewards.getReward(result).getName());
    }

    private Map<String, String> getAllReward() {
        Map<String, String> reward = new LinkedHashMap<>();

        for (int i = 0; i < players.getNumberOfPlayer(); i++) {
            int result = ladder.move(i);
            reward.put(players.findNameByIndex(i), rewards.getReward(result).getName());
        }

        return reward;
    }
}
