package domain;

import common.exception.message.ExceptionMessage;
import common.exception.model.NotFoundException;
import common.exception.model.ValidationException;

import java.util.Arrays;
import java.util.List;

public class LadderResults {
    private final List<LadderResult> values;

    public LadderResults(String[] values, int playerCount) {
        validateSize(values, playerCount);

        this.values = Arrays.stream(values)
                .map(LadderResult::new)
                .toList();
    }

    private void validateSize(String[] ladderResults, int playerCount) {
        if (ladderResults.length != playerCount) {
            throw new ValidationException(ExceptionMessage.LADDER_RESULTS_SIZE);
        }
    }

    public String getValueByIndex(int index) {
        try {
            return values.get(index).getValue();
        } catch (IndexOutOfBoundsException exception) {
            throw new NotFoundException(ExceptionMessage.NOT_FOUND_LADDER_RESULT);
        }
    }

    public int size() {
        return values.size();
    }
}
