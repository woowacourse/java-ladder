package model;

import util.ExceptionMessage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResult {
    private static final String SPLIT_DELIMITER = ",";

    private final List<Result> ladderResult;

    public LadderResult(String result, int personCount) {
        List<Result> splitResult = splitLadderResult(result);
        validateLadderResult(splitResult, personCount);
        this.ladderResult = splitResult;
    }

    private List<Result> splitLadderResult(String result) {
        List<String> splitResult = Arrays.asList(result.split(SPLIT_DELIMITER));
        return splitResult.stream().map(h -> new Result(h)).collect(Collectors.toList());
    }

    private void validateLadderResult(List<Result> result, int personCount) {
        if (result.size() != personCount || result.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_LADDER_RESULT.getExceptionMessage());
        }
    }

    public List<Result> getLadderResult() {
        return Collections.unmodifiableList(ladderResult);
    }

    public Result getLadderResultElement(int index) {
        return ladderResult.get(index);
    }
}
