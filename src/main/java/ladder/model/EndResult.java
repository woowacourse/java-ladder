package ladder.model;

import java.util.Map;

public class EndResult {
    private final Map<String, Result> results;

    public EndResult(Map<String, Result> results) {
        this.results = results;
    }

    public Result getMemberResult(String member) {
        return results.get(member);
    }

    public Map<String, Result> getAllResult() {
        return results;
    }
}
