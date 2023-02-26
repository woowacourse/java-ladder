package laddergame.domain.ladder.destination;

import java.util.ArrayList;
import java.util.List;
import laddergame.util.IndexValidator;

public class Destination {

    private final List<Item> items;

    public Destination(final List<Item> items) {
        this.items = items;
    }

    public int size() {
        return items.size();
    }

    public Item get(final int index) {
        IndexValidator.validateBounds(items, index);
        return items.get(index);
    }

    public List<Item> items() {
        return new ArrayList<>(items);
    }
}
