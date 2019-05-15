package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private Map<Player, String> result = new HashMap<>();

    public Result(List<Player> players, List<String> rewards) {
        for (Player player : players) {
            result.put(player, rewards.get(player.getPosition()));
        }
    }

    public Map<Player, String> getResult() {
        return result;
    }
}
