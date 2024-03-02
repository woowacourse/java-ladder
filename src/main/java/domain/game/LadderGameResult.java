package domain.game;

import domain.player.PlayerName;

public class LadderGameResult {
    private final PlayerName playerName;
    private final LadderDestination ladderDestination;

    public LadderGameResult(final PlayerName playerName, final LadderDestination ladderDestination) {
        this.playerName = playerName;
        this.ladderDestination = ladderDestination;
    }

    public LadderDestination getGameResult() {
        return ladderDestination;
    }

    public PlayerName getPlayerName() {
        return playerName;
    }

    public boolean isPlayerName(final String playerName) {
        return this.playerName.isEqualName(playerName);
    }
}
