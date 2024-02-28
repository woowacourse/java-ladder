package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LadderResult {

    private Map<String, String> results;

    public LadderResult(Map<String, String> results) {
        this.results = results;
    }

    public List<String> getWinning(String player) {
        if (player.equals("all")) {
            return getAll();
        }
        validateContains(player);
        return List.of(results.get(player));
    }

    private List<String> getAll() {
        List<String> resultAll = new ArrayList<>();
        for (Map.Entry<String, String> entry : results.entrySet()) {
            String player = entry.getKey();
            String winning = entry.getValue();
            resultAll.add(player + " : " + winning);
        }
        return resultAll;
    }

    private void validateContains(String player) {
        if (!results.containsKey(player)) {
            throw new IllegalArgumentException("입력되지 않은 사용자명입니다.");
        }
    }
}
