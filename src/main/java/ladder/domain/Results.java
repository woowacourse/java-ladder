package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Results {

    private static final String NOT_FOUND_RESULT_ERROR_MESSAGE = "[ERROR] Reward Index에 맞는 Result를 찾을 수 없습니다.";

    private final List<Result> results;

    public Results(final List<Result> results) {
        this.results = new ArrayList<>(results);
    }

    public Result findResultByRewardIndex(int rewardIndex) {
        return results.stream()
                .filter(result -> result.isSameReward(rewardIndex))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_RESULT_ERROR_MESSAGE));
    }
}
