package domain.result;

import domain.player.PlayerName;
import java.util.Map;

public class ClimbingResults {
    public static final String NOT_PARTICIPATION_PLAYER = "참가자가 아닙니다.";

    private final Map<PlayerName, LadderResult> playerResults;

    public ClimbingResults(final Map<PlayerName, LadderResult> playerResults) {
        this.playerResults = Map.copyOf(playerResults);
    }

    public LadderResult findResultByPlayerName(final String playerName) {
        PlayerName participatedPlayer = getParticipatedPlayer(playerName);
        return playerResults.get(participatedPlayer);
    }

    private PlayerName getParticipatedPlayer(final String playerName) {
        return playerResults.keySet().stream()
                .filter(name -> name.getValue().equals(playerName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_PARTICIPATION_PLAYER));
    }

    public Map<PlayerName, LadderResult> getAllResults() {
        return playerResults;
    }
}
