package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private Map<String, String> result = new HashMap<>();

    public Result(List<Player> players, List<String> rewards) {
        for (Player player : players) {
            result.put(player.getName(), rewards.get(player.getPosition()));
        }
    }

    public Map<String, String> getResult() {
        return result;
    }
}
