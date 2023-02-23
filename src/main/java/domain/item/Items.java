package domain.item;

import java.util.Collections;
import java.util.List;

public class Items {

    List<String> items;

    public Items(int count, List<String> items) {
        validate(count, items);
        this.items = items;
    }

    private void validate(int count, List<String> items) {
        if (count != items.size())
            throw new IllegalArgumentException("참가자 수와 실행 결과의 수가 일치해야 합니다.");
    }

    public List<String> getItems() {
        return Collections.unmodifiableList(items);
    }
}
