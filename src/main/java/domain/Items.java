package domain;

import java.util.ArrayList;
import java.util.List;

public class Items {
    private final List<Item> items;

    public Items(List<Item> items, Users users) {
        this.items = items;
        if (items.size() != users.getCount()) {
            throw new IllegalArgumentException("결과 값의 개수는 유저 수와 같아야 합니다.");
        }
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }
}
