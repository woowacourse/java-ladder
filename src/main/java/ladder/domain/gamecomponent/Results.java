package ladder.domain.gamecomponent;

import java.util.ArrayList;
import java.util.List;

public class Results {
    private static final String VIOLATE_GAME_RESULTS = "결과 값의 수가 참가자 수와 다릅니다.";

    private final List<Result> results = new ArrayList<>();

    public Results(List<String> resultNames, int playerNum) {
        checkNumberOfResult(resultNames, playerNum);
        for (String result : resultNames) {
            results.add(new Result(result));
        }
    }

    private void checkNumberOfResult(List<String> names, int playerNum) {
        if (names.size() != playerNum) {
            throw new IllegalArgumentException(VIOLATE_GAME_RESULTS);
        }
    }

    public List<Result> getResults() {
        return results;
    }
}
