package domain;

import java.util.*;

public class Result {
    private final Map<String, String> result;

    public Result(final List<String> inputResult, final Map<String, Integer> ladderGameResult) {
        result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> gameResult : ladderGameResult.entrySet()) {
            result.put(gameResult.getKey(), inputResult.get(gameResult.getValue()));
        }
    }

    public Map<String, String> getResult(final String inputResultWord) {
        if (inputResultWord.equals("all")) {
            return Collections.unmodifiableMap(new LinkedHashMap<>(result));
        }

        return Map.of(inputResultWord, result.get(inputResultWord));
    }

    public String getUserResult(final String userName) {
        return result.get(userName);
    }
}
