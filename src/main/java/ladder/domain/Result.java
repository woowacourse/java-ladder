package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private static final String NEW_LINE = "\n";

    private Map<Player, Reward> result = new HashMap<>();

    public Result(Players players, Rewards rewards, List<Integer> indices) {
        for (Integer index : indices) {
            result.put(players.getPlayer(indices.indexOf(index)), rewards.getReward(index));
        }
    }

    public boolean hasName(String name) {
        return result.containsKey(new Player(name));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Player, Reward> playerRewardEntry : result.entrySet()) {
            stringBuilder.append(playerRewardEntry.getKey().toString() + " : " + playerRewardEntry.getValue().toString() + NEW_LINE);
        }
        return stringBuilder.toString();
    }

    public String getReward(String name) {
        return result.get(new Player(name)).toString() + NEW_LINE;
    }
}