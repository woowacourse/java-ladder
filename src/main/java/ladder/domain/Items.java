package ladder.domain;

import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Items {
    private static final String INVALID_ITEM_COUNT_MESSAGE = "참가인원과 동일한 개수의 실행결과를 입력해야 합니다.";

    private final Map<Position, Item> items;

    private Items(final Map<Position, Item> items) {
        this.items = items;
    }

    public static Items from(final List<String> names, int playerCount) {
        validateItemCount(names, playerCount);
        final Map<Position, Item> items = new LinkedHashMap<>();
        for (int index = 0; index < names.size(); index++) {
            items.put(Position.valueOf(index), new Item(names.get(index)));
        }
        return new Items(items);
    }

    private static void validateItemCount(final List<String> items, final int playerCount) {
        if (items.size() != playerCount) {
            throw new IllegalArgumentException(INVALID_ITEM_COUNT_MESSAGE);
        }
    }

    public Item get(final Position position) {
        return items.get(position);
    }

    public List<String> getNames() {
        return items.values().stream()
                .map(Item::getName)
                .collect(toUnmodifiableList());
    }
}
