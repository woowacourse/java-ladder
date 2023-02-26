package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private final List<Result> results;

    public Results(List<String> results) {
        List<Result> resultList = new ArrayList<>();
        for (int i = 0; i < results.size(); i++) {
            resultList.add(new Result(results.get(i), i));
        }
        this.results = resultList;
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
        return results.stream()
                .map(Result::new)
                .collect(Collectors.toUnmodifiableList());
    }
}
