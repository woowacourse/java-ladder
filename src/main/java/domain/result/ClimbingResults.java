package domain.result;

import domain.ladder.Direction;
import domain.ladder.Floor;
import domain.player.Player;
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

    public static ClimbingResults of(final LadderResults ladderResults) {
        Map<String, String> results = new HashMap<>();
        List<Floor> floors = ladderResults.getFloors();
        for (Floor floor : floors) {
            climbLadder(ladderResults, floor, results);
        }
        return new ClimbingResults(results);
    }

    private static void climbLadder(
            final LadderResults ladderResults,
            final Floor floor,
            final Map<String, String> results) {
        for (int i = 0; i < ladderResults.getPlayerCount(); i++) {
            Player player = ladderResults.getPlayerIndexOf(i);
            Direction bridgeLocation = floor.getBridgeLocation(player.getPosition());
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
