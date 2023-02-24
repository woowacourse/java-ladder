package ladder.domain;

public class Item {
    private final Name itemName;
    private final Position position;

    public Item(String itemName, int position) {
        this.itemName = new Name(itemName);
        this.position = new Position(position);
    }

    public String getItemName() {
        return itemName.getValue();
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }
}
