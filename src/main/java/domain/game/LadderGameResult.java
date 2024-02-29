package domain.game;

import domain.player.PlayerName;

public class LadderGameResult {
    private final PlayerName playerName;
    private final GameResult gameResult;

    public LadderGameResult(final PlayerName playerName, final GameResult gameResult) {
        this.playerName = playerName;
        this.gameResult = gameResult;
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    public PlayerName getPlayerName() {
        return playerName;
    }

    public boolean isPlayerName(final String playerName) {
        return this.playerName.isEqualName(playerName);
    }
}
