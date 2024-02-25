package ladder.domain;

import java.util.ArrayList;
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
        return IntStream.range(0, userNames.getUserCount())
                .mapToObj(i -> new GameResult(userNames.findByOrder(i), finalDestinations.get(i)))
                .toList();
    }

    public void findByUserName(final String requestName) {
        boolean isNotExist = gameResults.stream()
                .noneMatch(result -> result.getUserName().isSame(requestName));
        if (isNotExist) {
            throw new IllegalArgumentException("존재하지 않는 참여자입니다.");
        }
    }
}
