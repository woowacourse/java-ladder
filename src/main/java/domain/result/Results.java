package domain.result;

import java.util.List;

public class Results {
    private static final int MIN_RESULT_SIZE = 2;

    private final List<Result> results;

    public Results(List<String> resultNames) {
        validate(resultNames);
        this.results = resultNames.stream()
                .map(Result::new)
                .toList();
    }

    private void validate(List<String> resultNames) {
        if (resultNames.size() < MIN_RESULT_SIZE) {
            throw new IllegalArgumentException("결과는 " + MIN_RESULT_SIZE + " 개 이상으로 구성되어야 합니다.");
        }
    }

    public int size() { // TODO : 얘가 정말 필요한 메서드인가?
        return results.size();
    }
}
