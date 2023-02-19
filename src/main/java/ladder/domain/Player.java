package ladder.domain;

public class Player {
    private final Name name;
    private final Position position;

    public Player(String name, int startPoint) {
        this.name = new Name(name);
        this.position = new Position(startPoint);
    }

    public String getName() {
        return name.getName();
    }

    public int getNameLength() {
        return name.getNameLength();
    }
}
