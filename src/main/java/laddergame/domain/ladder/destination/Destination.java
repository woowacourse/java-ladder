package laddergame.domain.ladder.destination;

import java.util.ArrayList;
import java.util.List;
import laddergame.util.IndexValidator;

public class Destination {

    private final List<Item> items;

    public Destination(List<Item> items) {
        this.items = items;
    }

    public int size() {
        return items.size();
    }

    public Item get(int index) {
        IndexValidator.validateBounds(index, items.size(), "주어진 위치가 종착지 정보의 개수보다 큽니다.");
        return items.get(index);
    }

    public List<Item> items() {
        return new ArrayList<>(items);
    }
}
