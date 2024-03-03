package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LadderResult {

    private static final String ALL_RESULT_COMMAND = "all";
    private static final String ALL_RESULT_DELIMITER = " : ";
    private final Map<String, String> results;

    public LadderResult(Map<String, String> results) {
        this.results = results;
    }

    public List<String> getWinning(String playerName) {
        if (ALL_RESULT_COMMAND.equals(playerName)) {
            return getAll();
        }
        validateContains(playerName);
        return List.of(results.get(playerName));
    }

    private List<String> getAll() {
        List<String> resultAll = new ArrayList<>();
        results.forEach((key, value) -> resultAll.add(
                String.join(ALL_RESULT_DELIMITER,
                        key,
                        value)
        ));
        return resultAll;
    }

    private void validateContains(String player) {
        if (!results.containsKey(player)) {
            throw new IllegalArgumentException("입력되지 않은 사용자명입니다.");
        }
    }
}
