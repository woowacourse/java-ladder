package domain.game;

import static view.InputView.RESULT_LENGTH_ERROR;

import java.util.List;

public class Results {
    private final List<String> results;

    public Results(List<String> results, int personCount) {
        if (results.size() != personCount) {
            throw new IllegalArgumentException(RESULT_LENGTH_ERROR);
        }
        this.results = results;
    }

    public List<String> getResults() {
        return results;
    }
}
