package ladder.domain;

public class Item {

    private final Name name;
    private Position position;

    public Item(final String name, final Position position) {
        this.name = new Name(name);
        this.position = position;
    }

    public String getName() {
        return name.getValue();
    }

    public Position getPosition() {
        return position;
    }
}
