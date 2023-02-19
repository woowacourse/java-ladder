package domain;

import java.util.ArrayList;
import java.util.List;

public class Items {
    private static final String INVALID_ITEM_COUNT_MESSAGE = "결과 값의 개수는 유저 수와 같아야 합니다.";
    private final List<Item> items;

    public Items(List<Item> items, Users users) {
        this.items = items;
        if (items.size() != users.getCount()) {
            throw new IllegalArgumentException(INVALID_ITEM_COUNT_MESSAGE);
        }
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }
}
