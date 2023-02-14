package domain;

public class Player {

    private final PlayerName playerName;

    public Player(final PlayerName playerName) {
        this.playerName = playerName;
    }

    public String getName() {
        return this.playerName.getName();
    }
}
