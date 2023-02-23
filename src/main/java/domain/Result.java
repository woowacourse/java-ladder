package domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<String, String> result;

    public Result(final List<String> inputResult, final Map<String, Integer> ladderGameResult) {
        result = new LinkedHashMap<>();
        for (String user : ladderGameResult.keySet()) {
            int finalPosition = ladderGameResult.get(user);
            result.put(user, inputResult.get(finalPosition));
        }
    }

    public String getUserResult(final String userName) {
        return result.get(userName);
    }

    public Map<String, String> getResult() {
        return Collections.unmodifiableMap(new LinkedHashMap<>(result));
    }
}
