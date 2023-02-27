package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Results {

    private static final String VALIDATE_RESULTS_COUNT = "사다리 결과의 수는 플레이어의 수 만큼 존재해야 한다.";

    private final List<Result> results;

    public Results(int playerCount, List<String> inputResults) {
        validateInputResults(playerCount, inputResults);
        results = Result.createResults(inputResults);
    }

    public List<Result> getResults() {
        return results;
    }

    private void validateInputResults(int playerCount, List<String> inputResults) {
        if (playerCount != inputResults.size()) {
            throw new IllegalArgumentException(VALIDATE_RESULTS_COUNT);
        }
    }

    public void matchPlayerName(List<Player> playerList) {
        for (int i = 0; i < results.size(); i++) {
            results.get(i).savePlayer(playerList.get(i).getName());
        }
    }

}
