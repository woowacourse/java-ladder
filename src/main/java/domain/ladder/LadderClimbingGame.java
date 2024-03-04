package domain.ladder;

import domain.player.PlayerName;
import domain.player.PlayerNames;
import domain.result.ClimbingResults;
import domain.result.LadderResult;
import domain.result.LadderResults;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderClimbingGame {
    private final PlayerNames playerNames;
    private final List<Floor> ladder;
    private final LadderResults ladderResults;

    public LadderClimbingGame(
            final PlayerNames playerNames,
            final List<Floor> ladder,
            final LadderResults ladderResults
    ) {
        this.playerNames = playerNames;
        this.ladder = ladder;
        this.ladderResults = ladderResults;
    }

    public ClimbingResults createClimbingResults() {
        Map<PlayerName, LadderResult> results = new HashMap<>();
        int playerCount = playerNames.getPlayerCount();
        for (int playerPosition = 0; playerPosition < playerCount; playerPosition++) {
            int finalPosition = getFinalPosition(playerPosition);
            LadderResult result = ladderResults.getLadderResultOfIndex(finalPosition);
            results.put(playerNames.getPlayerNameOfIndex(playerPosition), result);
        }
        return new ClimbingResults(results);
    }

    private int getFinalPosition(int curPosition) {
        int finalPosition = curPosition;
        for (Floor floor : ladder) {
            finalPosition = floor.getMovablePosition(finalPosition);
        }
        return finalPosition;
    }
}
