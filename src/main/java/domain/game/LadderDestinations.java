package domain.game;

import domain.ladder.LineNumber;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LadderDestinations {
    private final List<LadderDestination> ladderDestinations;

    public LadderDestinations(final List<LadderDestination> ladderDestinations) {
        this.ladderDestinations = ladderDestinations;
    }

    public static LadderDestinations of(final List<String> gameResults) {
        int gameResultsSize = gameResults.size();
        return IntStream.range(0, gameResultsSize)
                .mapToObj(i -> LadderDestination.of(gameResults.get(i), i + 1))
                .collect(collectingAndThen(toList(), LadderDestinations::new));
    }

    public List<String> getGameResults() {
        return ladderDestinations.stream()
                .map(LadderDestination::getDescription)
                .toList();
    }

    public LadderDestination findGameResult(final LineNumber lineNumber) {
        return ladderDestinations.stream()
                .filter(gameResult -> gameResult.isEqualLineNumber(lineNumber))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("라인 번호에 일치하는 결과가 없습니다."));
    }
}
