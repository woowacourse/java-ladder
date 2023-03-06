package domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Results {

    private final List<Result> results;

    private Results(List<Result> results) {
        this.results = results;
    }

    public static Results of(String[] result, int numberOfPlayers) {
        List<Result> results = Arrays.stream(result)
                .map(Result::new)
                .collect(Collectors.toList());

        validateNumberOfResults(results, numberOfPlayers);

        return new Results(results);
    }

    private static void validateNumberOfResults(List<Result> results, int numberOfPlayers) {
        if (results.size() != numberOfPlayers) {
            throw new IllegalArgumentException("[ERROR] 사다리 결과 수가 플레이어 수와 일치하지 않습니다.");
        }
    }

    public MatchingResult matchResults(Players players) {
        Map<Player, Result> matchingResult = new LinkedHashMap<>();
        for (Player player : players.getPlayers()) {
            int playerFinalPosition = player.getPosition();
            Result matchedResult = results.get(playerFinalPosition);
            matchingResult.put(player, matchedResult);
        }
        return new MatchingResult(matchingResult);
    }

    public List<Result> getResults() {
        return results;
    }
}
