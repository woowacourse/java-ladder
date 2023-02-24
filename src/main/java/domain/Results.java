package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Results {

    private final List<Result> results;

    public Results(List<String> results, People people) {
        validateResultsCount(results, people);
        this.results = results.stream()
                .map(Result::new)
                .collect(Collectors.toList());
    }

    public Results(List<Result> results) {
        this.results = new ArrayList<>(results);
    }

    public Results(Result singleResult) {
        this.results = new ArrayList<>();
        results.add(singleResult);
    }

    private void validateResultsCount(List<String> results, People people) {
        if (results.size() != people.getCount()) {
            throw new IllegalArgumentException("실행 결과의 수는 사람 수와 같아야 합니다.");
        }
    }

    public Result getResultByColumn(Column column) {
        validateColumn(column);
        return results.get(column.get());
    }

    private void validateColumn(Column column) {
        if (column.get() >= results.size()) {
            throw new IllegalArgumentException("유효 범위를 초과한 Column입니다.");
        }
    }

    public Result getSingleResult() {
        return results.get(0);
    }

    public boolean canTryAgain() {
        return this.results.size() == 1;
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Results results1 = (Results) o;
        return Objects.equals(results, results1.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
