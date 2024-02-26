package laddergame.domain.gameelements.results;

import laddergame.domain.gameelements.Elements;

import java.util.Collections;
import java.util.List;

public class Results extends Elements {
    private final List<Result> results;

    public Results(List<String> results, int peopleNumber) {
        super(results);
        validateResultsNumber(results, peopleNumber);
        this.results = results.stream()
                .map(Result::new)
                .toList();
    }

    private void validateResultsNumber(List<String> results, int peopleNumber) {
        if (results.size() != peopleNumber) {
            throw new IllegalArgumentException("참여자의 수와 사람의 수가 일치하지 않습니다");
        }
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }
}
