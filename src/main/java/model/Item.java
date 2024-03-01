package model;

public class Item {
    private final Name name;

    public Item(final String name) {
        this.name = new ItemName(name);
    }

    public String getName() {
        return name.getName();
    }
}
