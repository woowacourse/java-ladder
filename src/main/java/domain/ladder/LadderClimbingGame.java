package domain.ladder;

import domain.player.Player;
import domain.player.Players;
import domain.result.ClimbingResults;
import domain.result.LadderResult;
import domain.result.LadderResults;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderClimbingGame {
    private final Players players;
    private final Ladder ladder;
    private final LadderResults ladderResults;

    public LadderClimbingGame(final Players players, final Ladder ladder, final LadderResults ladderResults) {
        this.players = players;
        this.ladder = ladder;
        this.ladderResults = ladderResults;
    }

    public ClimbingResults createClimbingResults() {
        Map<Player, LadderResult> results = new HashMap<>();
        List<Floor> floors = ladder.createFloors();
        for (Floor floor : floors) {
            results.putAll(climbLadder(floor));
        }
        return new ClimbingResults(results);
    }

    private Map<Player, LadderResult> climbLadder(final Floor floor) {
        Map<Player, LadderResult> results = new HashMap<>();
        for (int i = 0; i < players.getPlayerCount(); i++) {
            Player player = players.getPlayerOfIndex(i);
            int nextPosition = floor.getMovablePosition(player.getPosition());
            player.moveTo(nextPosition);
            results.put(player, ladderResults.getLadderResultOfIndex(player.getPosition()));
        }
        return results;
    }
}
