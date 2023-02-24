package ladder.domain;

class Item {
    private final ItemName name;
    private final Position position;

    public Item(final String name, final Position position) {
        this.name = new ItemName(name);
        this.position = position;
    }

    public Item(final String name) {
        this.name = new ItemName(name);
        this.position = Position.valueOf(0);
    }
    
    public boolean isSamePosition(final Position position) {
        return this.position == position;
    }

    public String getName() {
        return name.getValue();
    }
}
