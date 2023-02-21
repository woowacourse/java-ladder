package domain;

import java.util.Map;

public class GameResultCalculator {

    private final Map<Player, LadderResult> playerWithResult;

    public GameResultCalculator(Map<Player, LadderResult> playerWithResult) {
        this.playerWithResult = playerWithResult;
    }

    public String findPlayerResult(final Player player) {
        return this.playerWithResult.get(player).getResult();
    }

    public Map<Player, LadderResult> findGameResult() {
        return playerWithResult;
    }
}
