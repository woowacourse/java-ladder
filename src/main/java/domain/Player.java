package domain;


import java.util.Objects;

public class Player {
    private final PlayerName name;

    public Player(String playerName) {
        this.name = new PlayerName(playerName);
    }

    public PlayerName getPlayerName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
