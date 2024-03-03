package laddergame.domain.gameelements;

import laddergame.domain.Position;

public class Prize {
    final Name name;
    final Position position;

    public Prize(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Name getName() {
        return name;
    }

    public Position position() {
        return position;
    }
}
