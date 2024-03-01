package domain.player;

import domain.common.Name;

public class Player {
    private final Name name;

    public Player(final Name name) {
        this.name = name;
    }

    public boolean isNameEqual(Name name) {
        return this.name.equals(name);
    }

    public Name getName() {
        return name;
    }
}
