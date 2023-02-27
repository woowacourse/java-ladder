package domain;

import java.util.*;
import java.util.stream.Collectors;

public class Results {

    List<Result> results;
    Map<Player, Result> matchingResult;

    private Results(List<Result> results) {
        this.results = results;
    }

    public static Results of(String[] result, int numberOfPlayers) {
        List<Result> results;
        results = Arrays.stream(result)
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

    public List<Result> getResults() {
        return results;
    }

    public MatchingResult matchResults(Players players) {
        this.matchingResult = new LinkedHashMap<>();
        for (Player player : players.getPlayers()) {
            int playerFinalPosition = player.getPosition();
            Result matchedResult  = results.get(playerFinalPosition);
            matchingResult.put(player, matchedResult);
        }
        return new MatchingResult(matchingResult);
    }
}
