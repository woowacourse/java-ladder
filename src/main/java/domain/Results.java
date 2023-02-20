package domain;

import java.util.ArrayList;
import java.util.List;

public class Results {

    private static final String SIZE_ERROR = "[ERROR] 결과값을 참여자 수 만큼 입력해야합니다.";

    private final List<Result> results = new ArrayList<>();

    public Results(int count, List<String> results) {
        validateSize(count, results);
        addResult(results);
    }

    public String getResult(int position) {
        return results.get(position)
                .getName();
    }

    private void addResult(List<String> results) {
        for (String result : results) {
            this.results.add(new Result(result));
        }
    }

    private void validateSize(int count, List<String> results) {
        if (results.size() != count) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
    }
}
