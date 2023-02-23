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

    public int getPosition() {
        return position.getValue();
    }

    public boolean isSamePosition(int position) {
        return this.position.getValue() == position;
    }
}
