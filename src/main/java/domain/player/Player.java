package domain.player;

public class Player {

    private final Name name;
    private final Position position;

    public Player(String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

    public Position getPosition() {
        return this.position;
    }

}
