package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Items {
    private static final String INVALID_ITEM_COUNT_MESSAGE = "결과 값의 개수는 유저 수와 같아야 합니다.";
    private final List<Item> items;

    private Items(List<Item> items) {
        this.items = items;
    }

    public static Items of(List<String> items, Users users) {
        validateSameSize(items, users);

        return new Items(items.stream()
                .map(Item::new)
                .collect(Collectors.toList()));
    }

    private static void validateSameSize(List<String> items, Users users) {
        if (items.size() != users.getCount()) {
            throw new IllegalArgumentException(INVALID_ITEM_COUNT_MESSAGE);
        }
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }
}
