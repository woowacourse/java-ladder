package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Items {
    private final List<Item> items;

    public Items(String[] itemNames, Players players) {
        validateSize(itemNames, players);
        this.items = Arrays.stream(itemNames)
                .map(item -> new Item(item.trim()))
                .collect(Collectors.toList());
    }

    private void validateSize(String[] itemNames, Players players) {
        if (!players.hasSameSize(itemNames.length)) {
            throw new IllegalArgumentException("사람 수와 실행 결과의 수가 다릅니다.");
        }
    }

    public Item getItem(int index) {
        return items.get(index);
    }

    public int getNumberOfItems() {
        return items.size();
    }
}
