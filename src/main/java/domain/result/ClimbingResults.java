package domain.result;

import domain.ladder.Direction;
import domain.ladder.Floor;
import domain.ladder.Ladder;
import domain.player.Player;
import domain.player.Players;
import domain.result.message.ResultExceptionMessage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import view.InputView;

public class ClimbingResults {
    private final Map<String, String> playerResults;

    private ClimbingResults(final Map<String, String> playerResults) {
        this.playerResults = playerResults;
    }

    public static ClimbingResults of(final Players players, final Ladder ladder, final LadderResults ladderResults) {
        Map<String, String> results = new HashMap<>();
        List<Floor> floors = ladder.getFloors();
        for (Floor floor : floors) {
            climbLadder(players, ladderResults, floor, results);
        }
        return new ClimbingResults(results);
    }

    private static void climbLadder(
            final Players players,
            final LadderResults ladderResults,
            final Floor floor,
            final Map<String, String> results) {
        for (int i = 0; i < players.getPlayerCount(); i++) {
            Player player = players.getPlayerOfIndex(i);
            Direction bridgeLocation = floor.getBridgePosition(player.getPosition());
            player.moveTo(bridgeLocation.getValue());
            results.put(player.getName(), ladderResults.getLadderResultOfIndex(player.getPosition()));
        }
    }

    public String findResultByPlayerName(final String playerName) {
        validateIsParticipant(playerName);
        return playerResults.get(playerName);
    }

    private void validateIsParticipant(final String playerName) {
        if (!playerName.equals(InputView.FINISH_COMMAND) && !playerResults.containsKey(playerName)) {
            throw new IllegalArgumentException(ResultExceptionMessage.NOT_PARTICIPATION_PLAYER);
        }
    }

    public Map<String, String> getAllResults() {
        return playerResults;
    }
}
