package domain.result;

import common.Command;
import domain.player.Player;
import java.util.Map;

public class ClimbingResults {
    public static final String NOT_PARTICIPATION_PLAYER = "참가자가 아닙니다.";

    private final Map<Player, LadderResult> playerResults;

    public ClimbingResults(final Map<Player, LadderResult> playerResults) {
        this.playerResults = Map.copyOf(playerResults);
    }

    public LadderResult findResultByPlayerName(final String playerName) {
        Player participatedPlayer = getParticipatedPlayer(playerName);
        return playerResults.get(participatedPlayer);
    }

    private Player getParticipatedPlayer(final String playerName) {
        return playerResults.keySet().stream()
                .filter(player -> player.getName().equals(playerName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_PARTICIPATION_PLAYER));
    }

    public Map<Player, LadderResult> getAllResults() {
        return playerResults;
    }
}
