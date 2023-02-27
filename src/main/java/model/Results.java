package model;

import java.util.ArrayList;
import java.util.List;

public class Results {

    private final List<String> results = new ArrayList<>();

    public Results(List<String> results, int numberOfPlayer) {
        validatePlayersAndResultsHaveEqualNumber(results, numberOfPlayer);
        this.results.addAll(results);
    }

    private void validatePlayersAndResultsHaveEqualNumber(List<String> results, int numberOfPlayer) {
        if (numberOfPlayer != results.size()) {
            throw new IllegalArgumentException("결과 수와 사람 수가 다릅니다");
        }
    }

    public String responseResult(int index) {
        return results.get(index);
    }
}
