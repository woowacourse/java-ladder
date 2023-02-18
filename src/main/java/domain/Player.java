package domain;


public class Player {
    private final PlayerName name;

    public Player(PlayerName playerName) {
        this.name = playerName;
    }

    public PlayerName getPlayerName() {
        return name;
    }
}
