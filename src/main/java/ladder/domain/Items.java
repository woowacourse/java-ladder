package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Items {
    private final List<Item> items;

    public Items(List<String> items) {
        this.items = new ArrayList<>();
        IntStream.range(0, items.size())
                .forEach(position -> this.items.add(new Item(items.get(position), position)));
    }

    public Item findItem(Position position) {
        return items.stream()
                .filter(item -> item.isSamePosition(position))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("플레이어의 실행 결과가 존재하지 않습니다."));
    }

    public List<String> getItems() {
        return items.stream()
                .map(Item::getItem)
                .collect(Collectors.toList());
    }
}
