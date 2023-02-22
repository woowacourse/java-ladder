package ladder.model;

public class Player {

    private final PlayerName playerName;

    public Player(String playerName) {
        this.playerName = new PlayerName(playerName);
    }

    public String getPlayerName() {
        return playerName.getPlayerName();
    }
}
