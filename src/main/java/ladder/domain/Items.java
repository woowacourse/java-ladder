package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Items {
    private final List<Item> items;

    private Items(List<Item> items) {
        this.items = items;
    }

    public static Items generate(List<String> names) {
        List<Item> items = new ArrayList<>();
        int position = 0;
        for (String name : names) {
            items.add(new Item(name, position++));
        }
        return new Items(items);
    }

    public List<Item> toUnmodifiableItems() {
        return Collections.unmodifiableList(items);
    }
}
