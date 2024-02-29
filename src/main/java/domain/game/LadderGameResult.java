package domain.game;

import domain.player.PlayerName;

public class LadderGameResult {

    private final PlayerName playerName;
    private final GameResult gameResult;

    public LadderGameResult(final PlayerName playerName, final GameResult gameResult) {
        this.playerName = playerName;
        this.gameResult = gameResult;
    }
}
