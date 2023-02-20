package model;

import util.ExceptionMessage;

import java.util.Arrays;
import java.util.List;

public class LadderResult {
    private static final String SPLIT_DELIMITER = ",";

    private final List<String> ladderResult;

    public LadderResult(String result, int personCount) {
        List<String> splitResult = splitLadderResult(result);
        validateLadderResult(splitResult, personCount);
        this.ladderResult = splitLadderResult(result);
    }

    private List<String> splitLadderResult(String result) {
        return Arrays.asList(result.split(SPLIT_DELIMITER));
    }

    private void validateLadderResult(List<String> result, int personCount) {
        if (result.size() != personCount || result.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_LADDER_RESULT.getExceptionMessage());
        }
    }

    public List<String> getLadderResult() {
        return ladderResult;
    }
}
