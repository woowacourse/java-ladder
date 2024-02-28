package domain;

import java.util.List;
import java.util.Map;

public class LadderResult {

    private Map<String, String> results;

    public LadderResult(Map<String, String> results) {
        this.results = results;
    }

    public List<String> getWinning(String player) {
        validateContains(player);
        return List.of(results.get(player));
    }

    private void validateContains(String player) {
        if (!results.containsKey(player)) {
            throw new IllegalArgumentException("입력되지 않은 사용자명입니다.");
        }
    }
}
