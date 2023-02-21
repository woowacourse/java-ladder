package ladder.domain;

import java.util.List;

public class Result {
    private final List<String> results;

    public Result(List<String> inputResult, int playerCount) {
        validateCount(inputResult.size(), playerCount);
        this.results = inputResult;
    }

    private void validateCount(int resultCount, int playerCount) {
        if (resultCount != playerCount) {
            throw new IllegalArgumentException("[ERROR] 입력된 결과의 수가 인원 수와 다를 수 없습니다.");
        }
    }

}
