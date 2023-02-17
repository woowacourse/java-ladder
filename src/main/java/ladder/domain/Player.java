package ladder.domain;

public class Player {
    private final Name name;
    private final StartPoint position;

    public Player(String name, int startPoint) {
        this.name = new Name(name);
        this.position = new StartPoint(startPoint);
    }

    public Name getName() {
        return name;
    }

    public int getNameLength() {
        return name.getNameLength();
    }
}
