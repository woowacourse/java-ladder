package ladder.domain;

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
