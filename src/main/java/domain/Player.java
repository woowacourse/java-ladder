package domain;

public class Player {

    private final Name name;
    private final Position position;

    public Player(String name, Position position) {
        this.name = new Name(name);
        this.position = position;
    }

    public String getName() {
        return name.getName();
    }

    public Position getPosition() {
        return position;
    }
}
