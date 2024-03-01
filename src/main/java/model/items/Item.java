package model.items;

import model.Name;

public class Item {
    private final Name name;

    public Item(final String rawName) {
        this.name = new ItemName(rawName);
    }

    public String getName() {
        return name.getName();
    }
}
