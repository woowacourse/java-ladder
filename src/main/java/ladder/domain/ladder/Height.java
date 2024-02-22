package ladder.domain.ladder;

import ladder.exception.ladder.InvalidHeightRangeException;

import java.util.List;

public class Height {
    private static final int MIN_HEIGHT = 1;

    private final int value;

    public Height(final int value) {
        validateHeightRange(value);
        this.value = value;
    }

    private void validateHeightRange(final int value) {
        if (value < MIN_HEIGHT) {
            throw new InvalidHeightRangeException();
        }
    }

    public boolean isGreaterThan(final List<LadderStep> ladderSteps) {
        return value > ladderSteps.size();
    }
}
