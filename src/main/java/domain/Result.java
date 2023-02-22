package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<String, String> result;

    public Result(List<String> inputResult, Map<String, Integer> ladderGameResult) {
        result = new LinkedHashMap<>();
        for (String user : ladderGameResult.keySet()) {
            int finalPosition = ladderGameResult.get(user);
            result.put(user, inputResult.get(finalPosition));
        }
    }

    public String getUserResult(String userName) {
        return result.get(userName);
    }
}
