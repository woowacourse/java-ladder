package domain;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGameResult {
    private final Map<Name, LadderResult> ladderGameResult;
    private final Names names;
    private final LadderResults ladderResults;
    private final Ladder ladder;

    public LadderGameResult(Names names, LadderResults ladderResults, Ladder ladder, LadderPositions ladderPositions) {
        validateNamesLadderResultLength(names, ladderResults, ladderPositions);
        this.names = names;
        this.ladderResults = ladderResults;
        this.ladder = ladder;
        ladderGameResult = mapNamesLadderResults(names, ladderResults, ladderPositions);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Names getNames() {
        return names;
    }

    public LadderResults getLadderResults() {
        return ladderResults;
    }

    public Map<Name, LadderResult> getLadderGameResult() {
        return Collections.unmodifiableMap(ladderGameResult);
    }

    public LadderResult getLadderResultFromName(Name name) {
        LadderResult ladderResult = ladderGameResult.get(name);
        if (ladderResult == null) {
            throw new LadderGameException(ExceptionType.INVALID_SEARCH_NAME);
        }
        return ladderResult;
    }

    private Map<Name, LadderResult> mapNamesLadderResults(Names names, LadderResults ladderResults,
                                                          LadderPositions ladderPositions) {
        return IntStream.range(0, names.getNames().size())
                .boxed()
                .collect(Collectors.toMap(index -> names.getNames().get(ladderPositions.getPosition(index)),
                        index -> ladderResults.getLadderResults().get(index)));

    }

    private void validateNamesLadderResultLength(Names names, LadderResults ladderResults,
                                                 LadderPositions ladderPositions) {
        if (names.count() != ladderResults.count()) {
            throw new LadderGameException(ExceptionType.NOT_ALLOW_DIFFERENT_NAMES_LADDER_RESULTS_LENGTH);
        }

        if (names.count() != ladderPositions.count()) {
            throw new LadderGameException(ExceptionType.NOT_ALLOW_DIFFERENT_NAMES_LADDER_RESULTS_LENGTH);
        }
    }


}
