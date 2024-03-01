package domain;

import domain.ladder.Ladder;
import domain.player.Name;
import domain.player.Names;
import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private final Names names;
    private final Results results;
    private final Ladder ladder;

    public LadderGame(final Names names, final Results results, final Ladder ladder) {
        validateSameCount(names.count(), results.count());

        this.names = names;
        this.results = results;
        this.ladder = ladder;
    }

    private void validateSameCount(final int namesCount, final int resultsCount) {
        if (namesCount != resultsCount) {
            throw new IllegalArgumentException("참가자 수와 실행 결과의 수는 같아야 합니다.");
        }
    }

    public GameResults calculateGameResults() {
        final List<GameResult> gameResults = new ArrayList<>();
        for (int startPosition = 0; startPosition < names.count(); startPosition++) {
            final GameResult gameResult = calculateGameResult(startPosition);
            gameResults.add(gameResult);
        }
        return new GameResults(gameResults);
    }

    private GameResult calculateGameResult(final int startPosition) {
        final Name name = names.getBy(startPosition);
        final int resultPosition = ladder.moveFrom(startPosition);
        final Result result = results.getBy(resultPosition);

        return new GameResult(name.value(), result.value());
    }

    public Names getNames() {
        return names;
    }

    public Results getResults() {
        return results;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
