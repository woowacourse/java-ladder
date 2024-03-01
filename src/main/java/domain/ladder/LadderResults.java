package domain.ladder;

import common.exception.model.NotFoundException;
import common.exception.model.ValidationException;

import java.util.Arrays;
import java.util.List;

public class LadderResults {
    public static final String NOT_FOUND_ERROR_MESSAGE = "존재하지 않는 사다리 실행 결과입니다";
    public static final String SIZE_ERROR_MESSAGE = "사다리 실행 결과의 수는 참가자의 수와 같아야 합니다";

    private final List<LadderResult> values;

    public LadderResults(final String[] values, final int playerCount) {
        validateSize(values, playerCount);

        this.values = Arrays.stream(values)
                .map(LadderResult::new)
                .toList();
    }

    private void validateSize(final String[] ladderResults, final int playerCount) {
        if (ladderResults.length != playerCount) {
            throw new ValidationException(SIZE_ERROR_MESSAGE);
        }
    }

    public int size() {
        return values.size();
    }

    public String getValueByIndex(final int index) {
        try {
            return values.get(index).getValue();
        } catch (IndexOutOfBoundsException exception) {
            throw new NotFoundException(NOT_FOUND_ERROR_MESSAGE);
        }
    }
}
