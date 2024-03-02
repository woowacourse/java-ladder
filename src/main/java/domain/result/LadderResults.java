package domain.result;

import java.util.List;

public class LadderResults {
    public static final String TOTAL_RESULTS_SIZE = "참가자 수와 동일하게 실행 결과를 입력해야 합니다.";

    private final List<LadderResult> results;

    private LadderResults(final List<LadderResult> results) {
        this.results = List.copyOf(results);
    }

    public static LadderResults createMatchesCountOf(final int count, final List<LadderResult> results) {
        validateTotalResults(count, results);
        return new LadderResults(results);
    }

    private static void validateTotalResults(final int count, final List<LadderResult> results) {
        if (results.size() != count) {
            throw new IllegalArgumentException(TOTAL_RESULTS_SIZE);
        }
    }

    public LadderResult getLadderResultOfIndex(final int index) {
        return results.get(index);
    }

    public int getLadderHeight() {
        return results.size();
    }
}
