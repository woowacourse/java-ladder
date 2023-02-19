package domain;

import java.util.Objects;

public class Player {

    private final Name name;

    public Player(Name name) {
        this.name = name;
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Player otherPlayer = (Player) other;
        return Objects.equals(this.name, otherPlayer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
