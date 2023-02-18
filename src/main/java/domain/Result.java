package domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private final List<String> result;

    public Result(List<String> result, int resultCount) {
        this.result = result;
        if (result.size() != resultCount) {
            throw new IllegalArgumentException("결과 값의 개수는 유저 수와 같아야 합니다.");
        }
    }

    public List<String> getResult() {
        return new ArrayList<>(result);
    }
}
