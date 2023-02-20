package domain;

public class Player {
    private final PlayerName playerName;
    private ResultContent resultContent;

    public Player(PlayerName playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName.getPlayerName();
    }
}
