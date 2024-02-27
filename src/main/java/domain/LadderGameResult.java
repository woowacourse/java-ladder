package domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGameResult {
    private final Map<Name, LadderResult> ladderGameResult;

    public LadderGameResult(Names names, LadderResults ladderResults) {
        validateNamesLadderResultLength(names, ladderResults);
        List<Name> swappedNames = names.getSwappedNames();
        ladderGameResult = IntStream.range(0, swappedNames.size())
                .boxed()
                .collect(Collectors.toMap(swappedNames::get, ladderResults.getLadderResults()::get));
    }

    public Map<Name, LadderResult> getLadderGameResult() {
        return Collections.unmodifiableMap(ladderGameResult);
    }

    private void validateNamesLadderResultLength(Names names, LadderResults ladderResults) {
        if (names.getNameCount() != ladderResults.getLadderResultCount()) {
            throw new LadderGameException(ExceptionType.NOT_ALLOW_DIFFERENT_NAMES_LADDER_RESULTS_LENGTH);
        }
    }
}
