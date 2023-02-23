package laddergame.domain.players;

import java.util.Objects;

public class Player {

    private final Name name;

    public Player(String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return name.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(name.getValue(), player.name.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.getValue());
    }
}
