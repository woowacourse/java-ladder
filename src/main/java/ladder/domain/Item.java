package ladder.domain;

public class Item {
    private final Name name;
    private final Position position;

    public Item(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public String getName() {
        return name.getValue();
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }
}
