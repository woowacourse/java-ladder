package domain;

import java.util.ArrayList;
import java.util.List;

public class Results {

    private final List<Result> results;

    public Results(int playerCount, List<String> inputResults) {
        validateInputResults(playerCount, inputResults);
        results = getResults(inputResults);
    }

    private void validateInputResults(int playerCount, List<String> inputResults) {
        if (playerCount != inputResults.size()) {
            throw new IllegalArgumentException("사다리 결과의 수는 플레이어의 수 만큼 존재해야 한다.");
        }
    }

    private List<Result> getResults(List<String> inputResults) {
        List<Result> resultList = new ArrayList<>();
        for (String result : inputResults) {
            resultList.add(new Result(result));
        }
        return resultList;
    }
}
