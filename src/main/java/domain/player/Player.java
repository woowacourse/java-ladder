package domain.player;

import domain.ResultContent;

public class Player {
    private final PlayerName playerName;
    private ResultContent resultContent;

    public Player(PlayerName playerName) {
        this.playerName = playerName;
    }

    public void updateResult(ResultContent resultContent) {
        this.resultContent = resultContent;
    }

    public String getPlayerName() {
        return playerName.getPlayerName();
    }

    public String getResultContent() {
        return resultContent.getContent();
    }
}
