package ladder.domain;

public class Item {
    private final String item;
    private final Position position;

    public Item(String item, int position) {
        this.item = item;
        this.position = new Position(position);
    }

    public String getItem() {
        return item;
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }
}
