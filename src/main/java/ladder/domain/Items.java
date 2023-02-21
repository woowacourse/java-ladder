package ladder.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;

public class Items {
    private static final String INVALID_ITEM_COUNT_MESSAGE = "참가인원과 동일한 개수의 실행결과를 입력해야 합니다.";

    private final List<Item> items;

    private Items(final List<Item> items) {
        this.items = items;
    }

    public static Items from(List<String> items, int playerCount) {
        validateItemCount(items, playerCount);
        return items.stream()
                .map(Item::new)
                .collect(collectingAndThen(toList(), Items::new));
    }

    private static void validateItemCount(final List<String> items, final int playerCount) {
        if (items.size() != playerCount) {
            throw new IllegalArgumentException(INVALID_ITEM_COUNT_MESSAGE);
        }
    }
}
