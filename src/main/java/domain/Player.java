package domain;

public class Player {
    private final Name name;
    private final Position position;

    public Player(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void moveLeft() {
        position.moveLeft();
    }

    public void moveRight() {
        position.moveRight();
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }
}
