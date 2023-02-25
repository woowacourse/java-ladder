package ladder.domain;

public class Item {
    private final ItemName name;
    private final Position position;

    private Item(final ItemName name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public static Item of(final String name, final int index) {
        return new Item(new ItemName(name), Position.valueOf(index));
    }

    public boolean isSamePosition(final Position position) {
        return this.position == position;
    }

    public String getName() {
        return name.getValue();
    }
}
