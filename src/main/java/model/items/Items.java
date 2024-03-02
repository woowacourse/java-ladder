package model.items;

import java.util.Collections;
import java.util.List;
import model.people.PersonCount;

public class Items {
    private final List<Item> items;
    private final ItemCount itemCount;

    private Items(final List<Item> items, final ItemCount itemCount) {
        this.items = Collections.unmodifiableList(items);
        this.itemCount = itemCount;
    }

    public static Items of(final List<String> itemNames, final PersonCount personCount) {
        ItemCount itemsCount = ItemCount.of(itemNames.size(), personCount);
        List<Item> items = itemNames.stream()
                .map(Item::new)
                .toList();
        return new Items(items, itemsCount);
    }

    public Item findBy(int index) {
        return items.get(index);
    }

    public List<String> getNames() {
        return items.stream()
                .map(Item::getName)
                .toList();
    }
}
