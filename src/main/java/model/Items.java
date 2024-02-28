package model;

import java.util.Collections;
import java.util.List;

public class Items {

    private final List<Item> items;

    public Items(final List<Item> items) {
        this.items = Collections.unmodifiableList(items);
    }

    public Item get(final int finalPosition) {
        return items.get(finalPosition);
    }
}
