package domain;

import domain.player.Position;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchingItems {

    private List<String> items;

    public MatchingItems(final List<String> items, final int playerCount) {
        validateCount(items.size(), playerCount);
        this.items = new ArrayList<>(items);
    }

    private void validateCount(final int itemsCount, final int playerCount) {
        if (itemsCount != playerCount) {
            throw new IllegalArgumentException("실행 결과의 개수는 참가자의 수와 일치해야 합니다.");
        }
    }

    public String get(final int position) {
        return items.get(position);
    }

    public List<String> getItems() {
        return Collections.unmodifiableList(items);
    }
}
