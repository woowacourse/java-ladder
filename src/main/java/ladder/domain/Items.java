package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Items {
    private final List<Item> items;

    private Items(List<Item> items) {
        this.items = items;
    }

    public static Items generate(List<String> names, int playerSize) {
        validateSize(names, playerSize);
        List<Item> items = new ArrayList<>();
        int position = 0;
        for (String name : names) {
            items.add(new Item(name, position++));
        }
        return new Items(items);
    }

    private static void validateSize(List<String> names, int playerSize) {
        if (names.size() != playerSize) {
            throw new IllegalArgumentException("플레이어와 당첨 결과는 개수가 같아야 합니다.");
        }
    }

    public List<Item> toUnmodifiableItems() {
        return Collections.unmodifiableList(items);
    }

    public int getSize() {
        return items.size();
    }

    public Item findBy(Position resultPosition) {
        return items.stream()
                .filter(item -> item.isSamePosition(resultPosition))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 위치에 당첨 결과가 없습니다"));
    }

    public List<String> getNameValues() {
        return items.stream()
                .map(Item::getName)
                .collect(Collectors.toList());
    }
}
