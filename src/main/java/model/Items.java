package model;

import java.util.Collections;
import java.util.List;

public class Items {

    private final List<Item> items;

    private Items(final List<Item> items) {
        this.items = Collections.unmodifiableList(items);
    }

    public static Items of(final List<Item> items, final int personCount) {
        int itemsCount = items.size();
        validateItemsCount(itemsCount, personCount);
        return new Items(items);
    }

    private static void validateItemsCount(final int itemsCount, final int personCount) {
        if (itemsCount != personCount) {
            throw new IllegalArgumentException("참여 인원 수와 결과 목록의 수가 동일하지 않습니다.");
        }
    }

    public Item get(final int finalPosition) {
        return items.get(finalPosition);
    }
}
