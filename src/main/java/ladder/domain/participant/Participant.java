package ladder.domain.participant;

import ladder.domain.Position;

public class Participant {
    private final Name name;
    private final Position startPosition;

    public Participant(final String name, final int startPosition) {
        this.name = new Name(name);
        this.startPosition = new Position(startPosition);
    }

    public String getName() {
        return name.value();
    }

    public Position getStartPosition() {
        return startPosition;
    }
}
