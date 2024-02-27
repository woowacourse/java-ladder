package domain;

import java.util.ArrayList;
import java.util.List;

public class Results {

    public static final String INVALID_RESULTS_COUNT = "실행 결과는 참가자 수보다 적거나 많을 수 없습니다.";
    private final List<String> values;

    private Results(final List<String> values) {
        this.values = new ArrayList<>(values);
    }

    public static Results of(final List<String> results, final int playerCount) {
        validateResultsSize(results, playerCount);
        return new Results(results);
    }

    private static void validateResultsSize(final List<String> results, final int playerCount) {
        if (results.size() != playerCount) {
            throw new IllegalArgumentException(INVALID_RESULTS_COUNT);
        }
    }
}
