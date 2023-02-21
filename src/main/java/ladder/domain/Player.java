package ladder.domain;

import java.util.Objects;

public class Player {
    private final PlayerName name;
    private Position position;

    public Player(String name) {
        this.name = new PlayerName(name);
    }

    public Player(PlayerName name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void move(Row row) {
        position = row.acceptPlayer(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player p = (Player) o;
        return Objects.equals(name, p.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name.getName();
    }

    public Position getPosition() {
        return position;
    }
}
