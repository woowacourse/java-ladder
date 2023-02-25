package domain.players;

public class Player {

    private final PlayerName name;

    public Player(final String name) {
        this.name = new PlayerName(name);
    }

    public String getName() {
        return name.getName();
    }

    public boolean isMyName(String playerName) {
        return name.isMyName(playerName);
    }

}
