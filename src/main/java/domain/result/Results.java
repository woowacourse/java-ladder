package domain.result;

import java.util.List;

public class Results {

    private final List<Result> results;

    public Results(List<String> results) {
        this.results = results.stream()
                .map(Result::new)
                .toList();
    }

    public int size() {
        return results.size();
    }

    public Result get(int index) {
        validateIndex(index);
        return results.get(index);
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= results.size()) {
            throw new IndexOutOfBoundsException("주어진 인덱스가 범위를 벗어납니다.");
        }
    }

    public List<String> getRawResults() {
        return results.stream()
                .map(Result::rawResult)
                .toList();
    }
}
