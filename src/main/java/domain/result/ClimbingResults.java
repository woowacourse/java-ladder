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
        for (Player player : playerResults.keySet()) {
            if (playerName.equals(Command.FINISH.getValue()) || player.getName().equals(playerName)) {
                return player;
            }
        }
        throw new IllegalArgumentException(NOT_PARTICIPATION_PLAYER);
    }

    public Map<Player, LadderResult> getAllResults() {
        return playerResults;
    }
}
