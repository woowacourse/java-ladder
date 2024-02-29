package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchingItems {

    private final List<String> items;

    public MatchingItems(final List<String> items) {
        this.items = new ArrayList<>(items);
    }

    public int count() {
        return items.size();
    }

    public String getBy(final int position) {
        return items.get(position);
    }

    public List<String> getItems() {
        return Collections.unmodifiableList(items);
    }
}
