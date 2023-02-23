package laddergame.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static laddergame.utils.OptionalUtils.getValueAfterNullCheck;

public class LadderMatchResults {
    private static final int MATCH_RESULT_SIZE_ONE = 1;

    private final Map<Name, Result> matchResults;

    public LadderMatchResults(final Names inputNames, final GameResults inputGameResults) {
        final Names names = getValueAfterNullCheck(inputNames);
        final GameResults gameResults = getValueAfterNullCheck(inputGameResults);
        matchResults = new LinkedHashMap<>();
        IntStream.range(0, names.getSize())
                .forEach(index -> {
                    final Position current = new Position(index);
                    matchResults.put(names.findNameByPosition(current), gameResults.findResultByPosition(current));
                });
    }

    public LadderMatchResults(final Name name, final Result gameResult) {
        matchResults = new LinkedHashMap<>();
        matchResults.put(name, gameResult);
    }

    public Result getFirstMatchResult() {
        return matchResults.entrySet()
                .stream()
                .findFirst()
                .orElseThrow()
                .getValue();
    }

    public boolean hasSizeGreaterThanOne() {
        return matchResults.size() > MATCH_RESULT_SIZE_ONE;
    }

    public Map<Name, Result> getMatchResults() {
        return new LinkedHashMap<>(matchResults);
    }

    public int getSize() {
        return matchResults.size();
    }
}
