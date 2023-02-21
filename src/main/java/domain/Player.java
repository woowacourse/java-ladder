package domain;

public class Player {

    private final Name name;
    private Position position;

    public Player(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
