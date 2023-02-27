package ladder.domain;

import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Items {
    static final String INVALID_ITEM_COUNT_MESSAGE = "참가인원과 동일한 개수의 실행결과를 입력해야 합니다.";
    static final String INVALID_ITEM_MESSAGE = "해당 위치에 있는 아이템이 존재하지 않습니다.";

    private final List<Item> items;

    private Items(final List<Item> items) {
        this.items = items;
    }

    public static Items of(final List<String> names, int playerCount) {
        validateItemCount(names, playerCount);
        return IntStream.range(0, names.size())
                .mapToObj(index -> Item.of(names.get(index), index))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Items::new));
    }

    private static void validateItemCount(final List<String> items, final int playerCount) {
        if (items.size() != playerCount) {
            throw new IllegalArgumentException(INVALID_ITEM_COUNT_MESSAGE);
        }
    }

    public Item findByPosition(final Position position) {
        return items.stream()
                .filter(item -> item.isSamePosition(position))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_ITEM_MESSAGE));
    }

    public List<String> getNames() {
        return items.stream()
                .map(Item::getName)
                .collect(toUnmodifiableList());
    }
}
