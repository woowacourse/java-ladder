package laddergame.domain.result;

import java.util.List;
import laddergame.domain.ladder.Position;

public class Results {

    private final List<Result> results;

    public Results(final List<String> results, final int size) {
        validateSize(results, size);

        this.results = results.stream()
                .map(Result::new)
                .toList();
    }

    private void validateSize(final List<String> results, final int size) {
        if (results.size() != size) {
            throw new IllegalArgumentException("[ERROR] 결과 수를 " + size + "개 입력해주세요.");
        }
    }

    public int size() {
        return results.size();
    }

    public Result get(final Position resultPosition) {
        return results.get(resultPosition.getPosition());
    }

    public List<Result> getResults() {
        return results;
    }
}
