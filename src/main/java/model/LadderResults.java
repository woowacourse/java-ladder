package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderResults {

    private final List<LadderResult> results;

    private LadderResults(List<LadderResult> results) {
        this.results = new ArrayList<>(results);
    }

    public static LadderResults of(List<String> results, int validResultSize) {
        validateResults(results, validResultSize);

        List<LadderResult> ladderResults = results.stream()
                .map(LadderResult::new)
                .collect(Collectors.toUnmodifiableList());

        return new LadderResults(ladderResults);
    }

    private static void validateResults(List<String> results, int validResultSize) {
        if (Objects.isNull(results)) {
            throw new IllegalStateException("실행 결과가 정상적으로 입력되지 않았습니다.");
        }
        if (results.size() != validResultSize) {
            throw new IllegalArgumentException("사다리 게임 결과는 참가자 수와 일치해야 합니다.");
        }
    }

    public String findResultByIndex(int index) {
        LadderResult ladderResult = results.get(index);

        return ladderResult.getResult();
    }

    public LadderResults calculateGameResult(List<Integer> gameResultIndex) {
        List<LadderResult> gameResults = IntStream.range(0, gameResultIndex.size())
                .map(gameResultIndex::get)
                .mapToObj(results::get)
                .collect(Collectors.toUnmodifiableList());

        return new LadderResults(gameResults);
    }

    public List<String> getResults() {
        return results.stream()
                .map(LadderResult::getResult)
                .collect(Collectors.toUnmodifiableList());
    }
}
