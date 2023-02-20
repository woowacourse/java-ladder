package ladder.domain;

public class Player {
    private final Name name;
    private final Position position;

    public Player(String name, int startPosition) {
        this.name = new Name(name);
        this.position = new Position(startPosition);
    }

    public Name getName() {
        return name;
    }
}
