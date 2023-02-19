package ladder.domain;

public class Player {
    private final Name name;
    private final Position position;

    public Player(String nameValue, int positionValue) {
        this.name = new Name(nameValue);
        this.position = new Position(positionValue);
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
