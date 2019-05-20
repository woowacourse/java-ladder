package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Results {
    private static final List<Result> results = new ArrayList<>();

    public Results(List<String> resultNames, int playerNum) {
        checkNumberOfResult(resultNames.size(), playerNum);
        for (String result : resultNames) {
            results.add(new Result(result));
        }
    }

    private void checkNumberOfResult(int resultNum, int playerNum) {
        if (resultNum != playerNum) {
            throw new IllegalArgumentException(UserOutput.VIOLATE_GAME_RESULTS.getOutputMessage());
        }
    }

    public static List<Result> getResults() {
        return results;
    }
}
