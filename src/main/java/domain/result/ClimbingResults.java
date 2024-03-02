package domain.result;

import common.Command;
import domain.ladder.Direction;
import domain.ladder.Floor;
import domain.ladder.Ladder;
import domain.player.Player;
import domain.player.Players;
import domain.result.message.ResultExceptionMessage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClimbingResults {
    private final Map<String, String> playerResults;

    private ClimbingResults(final Map<String, String> playerResults) {
        this.playerResults = Map.copyOf(playerResults);
    }

    public static ClimbingResults of(final Players players, final Ladder ladder, final LadderResults ladderResults) {
        Map<String, String> results = new HashMap<>();
        List<Floor> floors = ladder.getFloors();
        for (Floor floor : floors) {
            climbLadder(players, floor, ladderResults, results);
        }
        return new ClimbingResults(results);
    }

    private static void climbLadder(
            final Players players,
            final Floor floor,
            final LadderResults ladderResults,
            final Map<String, String> results) {
        for (int i = 0; i < players.getPlayerCount(); i++) {
            Player player = players.getPlayerOfIndex(i);
            int bridgeLocation = floor.getBridgePosition(player.getPosition());
            player.moveTo(bridgeLocation);
            results.put(player.getName(), ladderResults.getLadderResultOfIndex(player.getPosition()));
        }
    }

    public String findResultByPlayerName(final String playerName) {
        validateIsParticipant(playerName);
        return playerResults.get(playerName);
    }

    private void validateIsParticipant(final String playerName) {
        if (!playerName.equals(Command.FINISH.getValue()) && !playerResults.containsKey(playerName)) {
            throw new IllegalArgumentException(ResultExceptionMessage.NOT_PARTICIPATION_PLAYER);
        }
    }

    public Map<String, String> getAllResults() {
        return playerResults;
    }
}
