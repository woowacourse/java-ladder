package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private Map<String, String> result = new HashMap<>();

    public Result(Map<String, Integer> positions, List<String> rewards) {
        for (String name : positions.keySet()) {
            result.put(name, rewards.get(positions.get(name)));
        }
    }

    public Map<String, String> getResult() {
        return result;
    }
}
