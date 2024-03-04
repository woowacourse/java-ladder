package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static message.ErrorMessage.INVALID_RESULT_COUNT_EXCEPTION;

public class Results {

    private final Map<Position, Result> results;

    private Results(Map<Position, Result> results, int playerCount) {
        validateResultSize(results, playerCount);
        this.results = results;
    }

    public static Results of(List<Result> results, int playerCount) {
        AtomicInteger index = new AtomicInteger(0);
        Map<Position, Result> positionAndResult = results.stream()
                .collect(Collectors.toMap(
                        result -> new Position(index.getAndIncrement()),
                        result -> result,
                        (existingValue, newValue) -> newValue,
                        LinkedHashMap::new
                ));
        return new Results(positionAndResult, playerCount);
    }

    private void validateResultSize(Map<Position, Result> results, int playerCount) {
        if (results.size() != playerCount) {
            throw new IllegalArgumentException(INVALID_RESULT_COUNT_EXCEPTION.getMessageWithCause(results.size()));
        }
    }

    public Result findResult(Position position) {
        return results.get(position);
    }

    public List<Result> getResults() {
        return results.values().stream().toList();
    }
}
