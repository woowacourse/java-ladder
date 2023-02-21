package domain;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Results implements Iterable<Result> {

    private static final String DELIMITER = ",";

    private final List<Result> results;

    public Results(String result, People people) {
        this.results = validateAndGet(result, people);
    }

    public Results(List<Result> results) {
        this.results = results;
    }

    private List<Result> validateAndGet(String results, People people) {
        String[] split = results.split(DELIMITER);
        if (split.length != people.getCount()) {
            throw new IllegalArgumentException("실행 결과의 수는 사람 수와 같아야 합니다.");
        }
        return Arrays.stream(split)
                .map(Result::new)
                .collect(Collectors.toList());
    }

    public Result getResultByColumn(Position position) {
        return results.get(position.getColumn());
    }

    public Result getResultByColumn(int index) {
        return results.get(index);
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
