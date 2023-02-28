package ladder.domain.result;

import ladder.domain.result.exception.ResultNumberException;

import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private final List<Result> results;

    private Results(List<Result> results) {
        this.results = results;
    }

    public static Results of(int playerNumber, List<String> names) {
        validatePrizeCount(playerNumber, names.size());
        List<Result> results = names.stream()
                .map(Result::from)
                .collect(Collectors.toUnmodifiableList());
        return new Results(results);
    }

    private static void validatePrizeCount(int playerNumber, int prizeNumber) {
        if (playerNumber != prizeNumber) {
            throw new ResultNumberException();
        }
    }

    public Result findByIndex(final int index) {
        return results.get(index);
    }

    public List<Result> getResults() {
        return results;
    }
}
