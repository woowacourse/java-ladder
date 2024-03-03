package laddergame.domain.gameelements;

import laddergame.domain.Position;

public class Prize {
    final Name name;
    final Position position;

    public Prize(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String toString() {
        return name.toString();
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
