package domain.result;

import common.Command;
import java.util.Map;

public class ClimbingResults {
    public static final String NOT_PARTICIPATION_PLAYER = "참가자가 아닙니다.";

    private final Map<String, String> playerResults;

    public ClimbingResults(final Map<String, String> playerResults) {
        this.playerResults = Map.copyOf(playerResults);
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
