package ladder.domain.player;

public class Player {

    private final PlayerName playerName;

    public Player(final String name) {
        this.playerName = new PlayerName(name);
    }

    public PlayerName getPlayerName() {
        return playerName;
    }
}
