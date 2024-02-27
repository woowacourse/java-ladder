package ladder.domain;

import java.util.Map;

public class LadderGameResult {
    private final Map<Player, GameResult> playerGameResults;

    public LadderGameResult(final Map<Player, GameResult> playerGameResults) {
        this.playerGameResults = playerGameResults;
    }
}
