package result;

import java.util.List;

public class Results {

    private static final int MIN_RESULT_SIZE = 2;
    private static final int MAX_RESULT_SIZE = 10;

    private final List<Result> results;

    public Results(List<String> resultNames) {
        validateSize(resultNames);
        this.results = resultNames.stream()
                .map(Result::new)
                .toList();
    }

    private void validateSize(List<String> resultNames) {
        if (resultNames.size() < MIN_RESULT_SIZE || resultNames.size() > MAX_RESULT_SIZE) {
            throw new IllegalArgumentException("결과의 개수는 2개 이상 10개 이하로 작성해야 합니다.");
        }
    }

    public List<String> getNames() {
        return results.stream()
                .map(Result::getName)
                .toList();
    }

    public int size() {
        return results.size();
    }
}
