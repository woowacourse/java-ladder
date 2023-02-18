package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResults {

    private final List<LadderResult> results;

    public LadderResults(final List<String> results, final int numberOfPlayer) {
        validate(results, numberOfPlayer);
        this.results = makeResults(results);
    }

    // Todo: 예외 메시지 추가하기
    private void validate(final List<String> results, final int numberOfPlayer) {
        if (results.size() != numberOfPlayer) {
            throw new IllegalArgumentException();
        }
    }

    private List<LadderResult> makeResults(final List<String> results) {
        return results.stream()
                .map(LadderResult::new)
                .collect(Collectors.toList());
    }

    public String findFirstResult() {
        return this.getResults().get(0).getResult();
    }

    public List<LadderResult> getResults() {
        return Collections.unmodifiableList(this.results);
    }

    public int findLongestLadderResults() {
        return this.getResults().stream()
                .mapToInt(ladderResult -> ladderResult.getResult().length())
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }
}
