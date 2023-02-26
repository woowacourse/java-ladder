package ladder.domain.player;

import ladder.domain.Name;
import ladder.domain.Position;

public class Player {
    private final Name name;
    private final Position startPosition;

    public Player(String name, int startPosition) {
        this.name = new Name(name);
        this.startPosition = new Position(startPosition);
    }

    public Name getName() {
        return name;
    }

    public Position getStartPosition() {
        return startPosition;
    }
}
