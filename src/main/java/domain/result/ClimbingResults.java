package domain.result;

import common.Command;
import domain.ladder.Floor;
import domain.ladder.Ladder;
import domain.player.Player;
import domain.player.Players;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClimbingResults {
    public static final String NOT_PARTICIPATION_PLAYER = "참가자가 아닙니다.";

    private final Map<String, String> playerResults;

    private ClimbingResults(final Map<String, String> playerResults) {
        this.playerResults = Map.copyOf(playerResults);
    }

    public static ClimbingResults of(final Players players, final Ladder ladder, final LadderResults ladderResults) {
        Map<String, String> results = new HashMap<>();
        List<Floor> floors = ladder.getFloors();
        for (Floor floor : floors) {
            results.putAll(climbLadder(players, floor, ladderResults));
        }
        return new ClimbingResults(results);
    }

    private static Map<String, String> climbLadder(
            final Players players,
            final Floor floor,
            final LadderResults ladderResults) {
        Map<String, String> results = new HashMap<>();
        for (int i = 0; i < players.getPlayerCount(); i++) {
            Player player = players.getPlayerOfIndex(i);
            int bridgeLocation = floor.getBridgePosition(player.getPosition());
            player.moveTo(bridgeLocation);
            results.put(player.getName(), ladderResults.getLadderResultOfIndex(player.getPosition()));
        }
        return results;
    }

    public String findResultByPlayerName(final String playerName) {
        validateIsParticipant(playerName);
        return playerResults.get(playerName);
    }

    private void validateIsParticipant(final String playerName) {
        if (!playerName.equals(Command.FINISH.getValue()) && !playerResults.containsKey(playerName)) {
            throw new IllegalArgumentException(NOT_PARTICIPATION_PLAYER);
        }
    }

    public Map<String, String> getAllResults() {
        return playerResults;
    }
}
