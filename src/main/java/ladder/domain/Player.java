package ladder.domain;

public class Player {
    private final PlayerName playerName;

    public Player(String name) {
        this.playerName = new PlayerName(name);
    }

    public String getName() {
        return playerName.getName();
    }
}
