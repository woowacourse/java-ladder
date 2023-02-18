package domain;


public class Player {
    private final PlayerName name;

    public Player(String playerName) {
        this.name = new PlayerName(playerName);
    }

    public PlayerName getPlayerName() {
        return name;
    }
}
