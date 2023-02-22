package ladder.domain;

public class Item {
    private final ItemName name;
    private final Position position;

    public Item(String name, int position) {
        this.name = new ItemName(name);
        this.position = new Position(position);
    }

    public ItemName getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
