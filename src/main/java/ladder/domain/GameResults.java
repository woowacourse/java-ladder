package ladder.domain;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class GameResults {
    private final List<GameResult> gameResults;

    public GameResults(
            UserNames userNames,
            List<Integer> stepPositions,
            List<Destination> destinations) {
        this.gameResults = generateGameResults(userNames, stepPositions, destinations);
    }

    private static List<GameResult> generateGameResults(
            UserNames userNames,
            final List<Integer> stepPositions,
            final List<Destination> destinations) {
        List<Destination> finalDestinations = new ArrayList<>(destinations);
        for (int position : stepPositions) {
            Collections.swap(finalDestinations, position, position + 1);
        }
        return IntStream.range(0, userNames.getUserCount())
                .mapToObj(i -> new GameResult(userNames.findByOrder(i), finalDestinations.get(i)))
                .toList();
    }

    public String findByUserName(final String requestName) {
        GameResult gameResult = gameResults.stream()
                .filter(result -> result.getUserName().isSame(requestName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 참여자입니다."));
        return gameResult.getDestination().value();
    }

    public List<GameResult> findAll() {
        return unmodifiableList(gameResults);
    }
}
