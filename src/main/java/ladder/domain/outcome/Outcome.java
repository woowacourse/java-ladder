package ladder.domain.outcome;

import ladder.exception.outcome.InvalidOutcomeLengthException;

public record Outcome(String value) {
    private static final int MAX_OUTCOME_LENGTH = 4;

    public Outcome {
        value = value.trim();
        if (value.isEmpty() || value.length() > MAX_OUTCOME_LENGTH) {
            throw new InvalidOutcomeLengthException();
        }
    }
}
