package laddergame.domain;

import java.util.Objects;

public class Player {
    private final Name name;

    public Player(String nameInput) {
        Name name = new Name(nameInput);
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public boolean isPresent(String name) {
        return this.name.getName().equals(name);
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
        return Objects.hash(name);
    }
}
