package domain.result;

import java.util.List;

public class Results {
    private final List<Result> results;

    public Results(final List<Result> results) {
        this.results = results;
    }

    public Result findResultByIndex(final int index) {
        if (index < 0 || index >= results.size()) {
            throw new IllegalArgumentException("[ERROR] 범위를 벗어난 인덱스는 입력할 수 없습니다.");
        }
        return results.get(index);
    }
}
