package domain;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private final List<String> item;

    public Item(List<String> item, int resultCount) {
        this.item = item;
        if (item.size() != resultCount) {
            throw new IllegalArgumentException("결과 값의 개수는 유저 수와 같아야 합니다.");
        }
    }

    public List<String> getItem() {
        return new ArrayList<>(item);
    }
}
