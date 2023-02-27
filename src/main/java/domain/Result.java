package domain;

import java.util.*;

public class Result {
    private static final String ENTIRE_RESULT = "all";
    private final Map<String, WinningResult> result;

    private Result(final Map<String, WinningResult> result) {
        this.result = result;
    }

    public static Result of(final WinningResults winningResults, final Map<String, Integer> ladderGameResult) {
        final Map<String, WinningResult> result = new LinkedHashMap<>();

        for (Map.Entry<String, Integer> gameResult : ladderGameResult.entrySet()) {
            result.put(gameResult.getKey(), winningResults.findByDestinationPosition(gameResult.getValue()));
        }
        return new Result(result);
    }

    public Map<String, WinningResult> getResult(final String inputResultWord) {
        if (inputResultWord.equals(ENTIRE_RESULT)) {
            return Collections.unmodifiableMap(new LinkedHashMap<>(result));
        }

        return Map.of(inputResultWord, result.get(inputResultWord));
    }
}
