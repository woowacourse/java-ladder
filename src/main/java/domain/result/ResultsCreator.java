package domain.result;

import domain.exception.ExceptionType;
import domain.exception.LadderGameException;
import java.util.Arrays;
import java.util.List;

public class ResultsCreator {
    private static final String SEPARATOR = ",";

    public Results create(String rawLadderResults) {
        validateSeparator(rawLadderResults);
        return new Results(splitLadderResult(rawLadderResults));
    }

    private List<Result> splitLadderResult(String rawLadderResults) {
        return Arrays.stream(rawLadderResults.split(SEPARATOR))
                .map(Result::new)
                .toList();
    }

    private void validateSeparator(String rawLadderResults) {
        boolean startsWith = rawLadderResults.startsWith(SEPARATOR);
        boolean endsWith = rawLadderResults.endsWith(SEPARATOR);
        if (startsWith || endsWith) {
            throw new LadderGameException(ExceptionType.INVALID_SEPARATOR_POSITION);
        }
    }
}
