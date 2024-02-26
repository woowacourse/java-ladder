package domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGameResult {

    Names names;
    LadderResults ladderResults;

    public LadderGameResult(Names names, LadderResults ladderResults) {
        validateNamesLadderResultLength(names, ladderResults);
        this.names = names;
        this.ladderResults = ladderResults;
    }

    private void validateNamesLadderResultLength(Names names, LadderResults ladderResults) {
        if (names.getNameCount() != ladderResults.getLadderResultCount()) {
            throw new LadderGameException(ExceptionType.NOT_ALLOW_DIFFERENT_NAMES_LADDER_RESULTS_LENGTH);
        }
    }

    public Map<Name, LadderResult> getLadderGameResult() {
        List<Name> swappedNames = names.getSwappedNames();
        List<LadderResult> ladderResults = this.ladderResults.getLadderResults();

        return IntStream.range(0, swappedNames.size())
                .boxed()
                .collect(Collectors.toMap(swappedNames::get, ladderResults::get));
    }
}
