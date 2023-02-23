package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Results implements Iterable<Result> {

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

    public Result getResultByColumn(int index) {
        return results.get(index);
    }

    public Result getSingleResult() {
        return results.get(0);
    }

    public boolean canTryAgain() {
        return this.results.size() == 1;
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

    @Override
    public Iterator<Result> iterator() {
        return results.iterator();
    }
}
