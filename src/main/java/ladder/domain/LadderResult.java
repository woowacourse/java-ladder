package ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderResult {
    private Map<Player, ResultItem> ladderingResult = new LinkedHashMap<>();

    public void addResult(String name, ResultItem resultItem) {
        ladderingResult.put(new Player(name), resultItem);
    }

    public ResultItem getResultOf(String name) {
        if (!ladderingResult.containsKey(new Player(name))) {
            throw new IllegalArgumentException("존재하지 않는 플레이어입니다.");
        }
        return ladderingResult.get(new Player(name));
    }

    public Map<Player, ResultItem> getResultAll() {
        return ladderingResult;
    }
}
