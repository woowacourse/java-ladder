package ladder.domain;

import static java.util.Collections.unmodifiableList;

import java.util.List;
import java.util.stream.IntStream;

public class GameResults {
    private final List<GameResult> gameResults;

    public GameResults(
            UserNames userNames,
            List<Integer> stepPositions,
            Destinations destinations) {
        this.gameResults = generateGameResults(userNames, stepPositions, destinations);
    }

    private List<GameResult> generateGameResults(
            UserNames userNames,
            final List<Integer> stepPositions,
            Destinations destinations) {
        Destinations swappedDestinations = destinations.swapDestinations(stepPositions);
        return IntStream.range(0, userNames.getUserCount())
                .mapToObj(i -> new GameResult(userNames.findByOrder(i), swappedDestinations.findByOrder(i)))
                .toList();
    }

    public String findByUserName(final String requestName) {
        GameResult gameResult = gameResults.stream()
                .filter(result -> result.isSameName(requestName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 참여자입니다."));
        return gameResult.getDestination().value();
    }

    public List<GameResult> findAll() {
        return unmodifiableList(gameResults);
    }
}
