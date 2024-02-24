package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private final List<Result> results;

    public Results(Players players, List<String> inputResults) {
        validate(players, inputResults);

        this.results = inputResults.stream()
                .map(Result::new)
                .collect(Collectors.toList());
    }

    private static void validate(Players players, List<String> inputResults) {
        if (players.getTotalPlayerSize() != inputResults.size()) {
            throw new IllegalArgumentException(
                    String.format("입력한 결과의 수는 플레이어의 수와 일치해야 합니다. 입력한 결과 수: %d", inputResults.size()));
        }
    }

    public List<String> getResults() {
        return results.stream()
                .map(Result::getResult)
                .collect(Collectors.toList());
    }
}
