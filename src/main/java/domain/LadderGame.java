package domain;

import domain.ladder.Ladder;
import domain.player.Players;
import domain.player.Position;
import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private final Players players;
    private final Results results;
    private final Ladder ladder;

    public LadderGame(final Players players, final Results results, final Ladder ladder) {
        validateSameCount(players.count(), results.count());

        this.players = players;
        this.results = results;
        this.ladder = ladder;
    }

    private void validateSameCount(final int playersCount, final int resultsCount) {
        if (playersCount != resultsCount) {
            throw new IllegalArgumentException("참가자 수와 실행 결과의 수는 같아야 합니다.");
        }
    }

    public void play() {
        for (int playerIndex = 0; playerIndex < players.count(); playerIndex++) {
            final int resultPosition = ladder.moveFrom(playerIndex);
            players.setPosition(playerIndex, resultPosition);
        }
    }

    public GameResult matchResult(final String playerName) {
        final Position position = players.getPositionBy(playerName);
        final Result result = results.getBy(position.value());

        return new GameResult(playerName, result.value());
    }

    public List<GameResult> matchResultAll() {
        final List<GameResult> allResults = new ArrayList<>();
        for (int index = 0; index < players.count(); index++) {
            final Position position = players.getPositionBy(index);
            final Result result = results.getBy(position.value());
            final GameResult eachResult = new GameResult(players.getNameBy(index), result.value());

            allResults.add(eachResult);
        }
        return allResults;
    }

    public List<String> getPlayerNames() {
        return players.getNames();
    }

    public Results getResults() {
        return results;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
