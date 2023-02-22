package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LadderResults {

    private final List<LadderResult> results;

    private LadderResults(List<LadderResult> results) {
        this.results = new ArrayList<>(results);
    }

    public static LadderResults of(List<LadderResult> results, int validResultSize) {
        validateResults(results, validResultSize);

        return new LadderResults(results);
    }

    private static void validateResults(List<LadderResult> results, int validResultSize) {
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

    public int getResultSize() {
        return results.size();
    }
}
