package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private final List<Result> results;

    public Results(List<String> results, People people) {
        validateResultsCount(results, people);
        this.results = results.stream()
                .map(Result::new)
                .collect(Collectors.toList());
    }

    private void validateResultsCount(List<String> results, People people) {
        if (results.size() != people.getCount()) {
            throw new IllegalArgumentException("실행 결과의 수는 사람 수와 같아야 합니다.");
        }
    }

    private void validateColumn(Column column) {
        if (column.get() >= results.size()) {
            throw new IllegalArgumentException("유효 범위를 초과한 column입니다.");
        }
    }

    public Result getResultByColumn(Column column) {
        validateColumn(column);
        return results.get(column.get());
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }
}
