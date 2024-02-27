package ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class GameResults {
    private final List<GameResult> gameResults;

    public GameResults(final List<GameResult> gameResults) {
        this.gameResults = gameResults;
    }

    public static GameResults of(final List<String> gameResults) {
        int gameResultsSize = gameResults.size();
        return IntStream.range(0, gameResultsSize)
                .mapToObj(i -> GameResult.of(gameResults.get(i), i + 1))
                .collect(collectingAndThen(toList(), GameResults::new));
    }

    public List<String> getGameResults() {
        return gameResults.stream().map(GameResult::getGameResultDescriptionValue)
                .toList();
    }
}
