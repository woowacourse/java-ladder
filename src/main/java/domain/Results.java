package domain;

import java.util.List;

import static message.ErrorMessage.INVALID_RESULT_COUNT_EXCEPTION;

public class Results {

    private final List<Result> results;

    public Results(List<Result> results, int playerCount) {
        validateResultSize(results, playerCount);
        this.results = results;
    }

    private void validateResultSize(List<Result> results, int playerCount) {
        if (results.size() != playerCount) {
            throw new IllegalArgumentException(INVALID_RESULT_COUNT_EXCEPTION.getMessageWithCause(results.size()));
        }
    }

    public List<Result> getResults() {
        return results;
    }
}
