package domain;

import domain.exception.ExceptionType;
import domain.exception.LadderGameException;
import domain.ladder.Ladder;
import domain.ladder.LadderPositions;
import domain.name.Name;
import domain.name.Names;
import domain.result.Result;
import domain.result.Results;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGameResult {
    private final Map<Name, Result> ladderGameResult;
    private final Names names;
    private final Results results;
    private final Ladder ladder;

    public LadderGameResult(Names names, Results results, Ladder ladder, LadderPositions ladderPositions) {
        validateNamesLadderResultLength(names, results, ladderPositions);
        this.names = names;
        this.results = results;
        this.ladder = ladder;
        ladderGameResult = mapNamesLadderResults(names, results, ladderPositions);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Names getNames() {
        return names;
    }

    public Results getLadderResults() {
        return results;
    }

    public Result getLadderResultFromName(Name name) {
        Result result = ladderGameResult.get(name);
        if (result == null) {
            throw new LadderGameException(ExceptionType.INVALID_SEARCH_NAME);
        }
        return result;
    }

    private Map<Name, Result> mapNamesLadderResults(Names names, Results results,
                                                    LadderPositions ladderPositions) {
        return IntStream.range(0, names.count())
                .boxed()
                .collect(Collectors.toMap(
                        index -> names.getNames().get(ladderPositions.getPosition(index)),
                        index -> results.getLadderResults().get(index)));

    }

    private void validateNamesLadderResultLength(Names names, Results results,
                                                 LadderPositions ladderPositions) {
        if (names.count() != results.count()) {
            throw new LadderGameException(ExceptionType.NOT_ALLOW_DIFFERENT_NAMES_LADDER_RESULTS_LENGTH);
        }

        if (names.count() != ladderPositions.count()) {
            throw new LadderGameException(ExceptionType.NOT_ALLOW_DIFFERENT_NAMES_LADDER_RESULTS_LENGTH);
        }
    }


}
