package domain;

import java.util.Arrays;
import java.util.List;

public class LadderResultCreator {
    private static final String SEPARATOR = ",";

    public LadderResults create(String rawLadderResults) {
        validateSeparator(rawLadderResults);
        return new LadderResults(splitLadderResult(rawLadderResults));
    }

    private List<LadderResult> splitLadderResult(String rawLadderResults) {
        return Arrays.stream(rawLadderResults.split(SEPARATOR))
                .map(LadderResult::new)
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
