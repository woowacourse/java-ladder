package domain;

import domain.ladder.Ladder;
import domain.player.PlayerName;
import domain.player.PlayerNames;
import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private final PlayerNames playerNames;
    private final Results results;
    private final Ladder ladder;

    public LadderGame(final PlayerNames playerNames, final Results results, final Ladder ladder) {
        validateSameCount(playerNames.count(), results.count());

        this.playerNames = playerNames;
        this.results = results;
        this.ladder = ladder;
    }

    private void validateSameCount(final int playersCount, final int resultsCount) {
        if (playersCount != resultsCount) {
            throw new IllegalArgumentException("참가자 수와 실행 결과의 수는 같아야 합니다.");
        }
    }

    public GameResults calculateGameResults() {
        final List<GameResult> gameResults = new ArrayList<>();
        for (int startPosition = 0; startPosition < playerNames.count(); startPosition++) {
            final GameResult gameResult = calculateGameResult(startPosition);
            gameResults.add(gameResult);
        }
        return new GameResults(gameResults);
    }

    private GameResult calculateGameResult(final int startPosition) {
        final PlayerName playerName = playerNames.findBy(startPosition);

        final int resultPosition = ladder.calculateResultPosition(startPosition);
        final Result result = results.getBy(resultPosition);

        return new GameResult(playerName.value(), result.value());
    }

    public PlayerNames getNames() {
        return playerNames;
    }

    public Results getResults() {
        return results;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
