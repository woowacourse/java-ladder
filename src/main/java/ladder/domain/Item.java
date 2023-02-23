package ladder.domain;

public class Item {
    private final ItemName name;
    private final Position position;

    public Item(String name, int position) {
        this.name = new ItemName(name);
        this.position = new Position(position);
    }

    public String getName() {
        return name.getValue();
    }

    public Position getPosition() {
        return position;
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }
}
