package domain;

import java.util.ArrayList;
import java.util.List;

public class Results {
    private final List<Result> results;

    public Results(List<Result> results, int numberOfNames) {
        validate(results, numberOfNames);
        this.results = new ArrayList<>(results);
    }

    private void validate(List<Result> results, int numberOfNames) {
        if (results.size() != numberOfNames) {
            throw new IllegalArgumentException("이름과 결과의 수는 같아야 합니다.");
        }
    }
}
