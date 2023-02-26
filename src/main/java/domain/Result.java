package domain;

import java.util.*;

public class Result {
    private final Map<String, WinningResult> result;

    public Result(final WinningResults inputWinningResults, final Map<String, Integer> ladderGameResult) {
        result = new LinkedHashMap<>();
        final List<WinningResult> winningResults = inputWinningResults.getWinningResults();
        for (Map.Entry<String, Integer> gameResult : ladderGameResult.entrySet()) {
            result.put(gameResult.getKey(), winningResults.get(gameResult.getValue()));
        }
    }

    public Map<String, WinningResult> getResult(final String inputResultWord) {
        if (inputResultWord.equals("all")) {
            return Collections.unmodifiableMap(new LinkedHashMap<>(result));
        }

        return Map.of(inputResultWord, result.get(inputResultWord));
    }
}
