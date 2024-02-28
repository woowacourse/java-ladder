package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGameResult {
    private final Map<Name, LadderResult> ladderGameResult;

    public LadderGameResult(Names names, LadderResults ladderResults, Ladder ladder) {
        validateNamesLadderResultLength(names, ladderResults);
        ladderGameResult = calculateLadderGameResult(names, ladderResults, ladder);
    }

    public Map<Name, LadderResult> getLadderGameResult() {
        return Collections.unmodifiableMap(ladderGameResult);
    }

    public LadderResult getLadderResultFromName(Name name) {
        return ladderGameResult.get(name);
    }

    private Map<Name, LadderResult> calculateLadderGameResult(Names names, LadderResults ladderResults, Ladder ladder) {
        Map<Integer, Integer> nameIndexMap = new HashMap<>();
        initNameIndexMap(names, nameIndexMap);
        calculateLadder(ladder, nameIndexMap);
        return setLadderGameResult(names, ladderResults, nameIndexMap);
    }

    private Map<Name, LadderResult> setLadderGameResult(Names names, LadderResults ladderResults,
                                                        Map<Integer, Integer> nameIndexMap) {
        return IntStream.range(0, names.getNames().size())
                .boxed()
                .collect(Collectors.toMap(index -> names.getNames().get(index),
                        index -> ladderResults.getLadderResults().get(nameIndexMap.get(index))));
    }

    private void calculateLadder(Ladder ladder, Map<Integer, Integer> nameIndexMap) {
        ladder.getLadder().stream()
                .map(Bridges::getBridges)
                .forEach(bridges -> swapNameIndexMap(nameIndexMap, bridges));
    }

    private void initNameIndexMap(Names names, Map<Integer, Integer> nameIndexMap) {
        IntStream.range(0, names.count())
                .forEach(index -> nameIndexMap.put(index, index));
    }

    private void swapNameIndexMap(Map<Integer, Integer> nameIndexMap, List<Boolean> bridges) {
        IntStream.range(0, bridges.size())
                .forEach(index -> swapIfBridgeExist(nameIndexMap, index, bridges));
    }

    private void swapIfBridgeExist(Map<Integer, Integer> nameIndexMap, int index, List<Boolean> bridges) {
        if (bridges.get(index)) {
            var right = nameIndexMap.get(index + 1);
            var left = nameIndexMap.get(index);
            nameIndexMap.put(index + 1, left);
            nameIndexMap.put(index, right);
        }
    }
    
    private void validateNamesLadderResultLength(Names names, LadderResults ladderResults) {
        if (names.count() != ladderResults.count()) {
            throw new LadderGameException(ExceptionType.NOT_ALLOW_DIFFERENT_NAMES_LADDER_RESULTS_LENGTH);
        }
    }
}
