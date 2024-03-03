package domain;

import domain.exception.ExceptionType;
import domain.exception.LadderGameException;
import domain.ladder.Ladder;
import domain.name.Name;
import domain.name.Names;
import domain.result.Result;
import domain.result.Results;
import java.util.Map;

public class LadderGameResult {
    private final Map<Name, Result> ladderGameResult;
    private final Names names;
    private final Results results;
    private final Ladder ladder;

    public LadderGameResult(Names names, Results results, Ladder ladder, Map<Name, Result> ladderGameResult) {
        validateNamesLadderResultLength(names, results, ladderGameResult);
        this.names = names;
        this.results = results;
        this.ladder = ladder;
        this.ladderGameResult = ladderGameResult;
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

    private void validateNamesLadderResultLength(Names names, Results results,
                                                 Map<Name, Result> ladderGameResult) {
        if (names.count() != results.count()) {
            throw new LadderGameException(ExceptionType.NOT_ALLOW_DIFFERENT_NAMES_LADDER_RESULTS_LENGTH);
        }

        if (names.count() != ladderGameResult.size()) {
            throw new LadderGameException(ExceptionType.NOT_ALLOW_DIFFERENT_NAMES_LADDER_RESULTS_LENGTH);
        }
    }


}
