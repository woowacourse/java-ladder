package domain;

import java.util.List;

public class Results {
    private static final String INVALID_RESULT_COUNT = "실행 결과의 개수가 사람 이름의 개수와 일치하지 않습니다.";

    private final List<Result> results;

    public Results(final List<String> values, final int nameCount) {
        validateResultSize(values, nameCount);
        this.results = values.stream()
                .map(Result::new)
                .toList();
    }

    private void validateResultSize(final List<String> values, final int nameCount) {
        if (values.size() != nameCount) {
            throw new IllegalArgumentException(INVALID_RESULT_COUNT);
        }
    }

    public List<String> getAll() {
        return results.stream()
                .map(Result::getValue)
                .toList();
    }

    public String resultOf(final int index) {
        return results.get(index).getValue();
    }

    public int size() {
        return results.size();
    }
}
