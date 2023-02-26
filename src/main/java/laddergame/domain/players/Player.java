package laddergame.domain.players;

import java.util.Objects;

public class Player {

    private final Name name;

    public Player(final String name) {
        this.name = new Name(name);
    }

    public Name getName() {
        return name;
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
