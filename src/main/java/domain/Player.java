package domain;

final public class Player {

    private final Name name;
    private final Position position;

    public Player(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Name name() {
        return name;
    }

    public Position position() {
        return new Position(position.value());
    }
}
