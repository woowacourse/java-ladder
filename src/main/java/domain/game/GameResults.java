package domain.game;

import domain.ladder.LineNumber;

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
        return gameResults.stream()
                .map(gameResult -> gameResult.getGameResultDescription().value())
                .toList();
    }

    public GameResult findGameResult(final LineNumber lineNumber) {
        return gameResults.stream()
                .filter(gameResult -> gameResult.isEqualLineNumber(lineNumber))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("라인 번호에 일치하는 결과가 없습니다."));
    }
}
