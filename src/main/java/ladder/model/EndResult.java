package ladder.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EndResult {
    private final Map<String, Result> endResult;

    public EndResult(final Map<String, Result> endResult) {
        this.endResult = endResult;
    }

    public void put(String name, Result result) {
        endResult.put(name, result);
    }

    public Result get(String name) {
        return endResult.get(name);
    }

    public Map<String, Result> getAll() {
        return new HashMap<>(endResult);
    }
}
