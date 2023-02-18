package domain;

import java.util.Collections;
import java.util.List;

public class LadderResults {

    private final List<LadderResult> results;

    public LadderResults(final List<LadderResult> results, final int numberOfPlayer) {
        validate(results, numberOfPlayer);
        this.results = results;
    }

    // Todo: 예외 메시지 추가하기
    private void validate(final List<LadderResult> results, final int numberOfPlayer) {
        if(results.size() != numberOfPlayer) {
            throw new IllegalArgumentException();
        }
    }

    public List<LadderResult> getResults() {
        return Collections.unmodifiableList(this.results);
    }
}
