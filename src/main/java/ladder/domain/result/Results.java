package ladder.domain.result;

import ladder.domain.result.exception.ResultNumberException;

import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private final List<Result> results;

    public Results(int playerNumber, List<String> names) {
        validatePrizeCount(playerNumber, names.size());

        this.results = names.stream()
                .map(Result::from)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validatePrizeCount(int playerNumber, int prizeNumber) {
        if (playerNumber != prizeNumber) {
            throw new ResultNumberException();
        }
    }

    public List<Result> getPrizes() {
        return results;
    }
}
