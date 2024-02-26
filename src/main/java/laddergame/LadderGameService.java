package laddergame;

import java.util.List;
import laddergame.domain.Height;
import laddergame.domain.Ladder;
import laddergame.domain.Players;
import laddergame.domain.PlayersResults;
import laddergame.domain.Results;
import laddergame.domain.strategy.BuildStrategy;
import laddergame.domain.strategy.PointBuildStrategy;

public class LadderGameService {
    public Players getPlayers(final List<String> playerNames) {
        return Players.from(playerNames);
    }

    public Results getResults(final List<String> results, final int playersSize) {
        return Results.from(results, playersSize);
    }

    public Height getHeight(final String height) {
        return new Height(height);
    }

    public Ladder getLadder(final Players players, final Height height, final Results results) {
        final BuildStrategy pointBuildStrategy = new PointBuildStrategy();
        return new Ladder(players, height, results, pointBuildStrategy);
    }

    public PlayersResults getPlayersResults(final Ladder ladder) {
        return ladder.getPlayersResults();
    }
}
