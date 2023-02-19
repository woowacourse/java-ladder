package domain;

import java.util.HashMap;
import java.util.List;

public class LadderResults {

    private final HashMap<Integer, LadderResult> ladderResults;

    public LadderResults(final List<String> results, final int numberOfPlayer) {
        validate(results, numberOfPlayer);
        this.ladderResults = makeResults(results);
    }

    // Todo: 예외 메시지 추가하기
    private void validate(final List<String> results, final int numberOfPlayer) {
        if (results.size() != numberOfPlayer) {
            throw new IllegalArgumentException();
        }
    }

    private HashMap<Integer, LadderResult> makeResults(final List<String> results) {
        HashMap<Integer, LadderResult> ladderResults = new HashMap<>();

        for (int i = 0; i < results.size(); i++) {
            ladderResults.put(i, new LadderResult(results.get(i)));
        }

        return ladderResults;
    }

    public String findFirstResult() {
        return this.ladderResults.get(0).getResult();
    }

    public int findLongestLadderResults() {
        return this.ladderResults.values().stream()
                .mapToInt(ladderResult -> ladderResult.getResult().length())
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getLadderResultOfIndex(final int index) {
        return ladderResults.get(index).getResult();
    }

    public HashMap<Integer, LadderResult> getLadderResults() {
        return ladderResults;
    }
}
