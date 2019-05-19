package ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderResult {
    private Map<String, ResultItem> ladderingResult = new LinkedHashMap<>();

    public void addResult(String name, ResultItem resultItem) {
        ladderingResult.put(name, resultItem);
    }

    public ResultItem getResultOf(String name) {
        if (!ladderingResult.containsKey(name)) {
            throw new IllegalArgumentException("존재하지 않는 플레이어입니다.");
        }
        return ladderingResult.get(name);
    }

    public Map<String, ResultItem> getResultAll() {
        return ladderingResult;
    }
}
