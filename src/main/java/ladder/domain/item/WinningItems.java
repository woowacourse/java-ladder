package ladder.domain.item;

import java.util.ArrayList;
import java.util.List;

public class WinningItems {
    private static final int MIN_SIZE = 2;

    private List<WinningItem> winningItems;

    public WinningItems(List<String> winningItemNames) {
        List<String> copy = new ArrayList<>(winningItemNames);
        validateSize(copy);

        winningItems = copy.stream()
                .map(WinningItem::new)
                .toList();
    }

    private void validateSize(List<String> winningItemNames) {
        if (winningItemNames.size() < MIN_SIZE) {
            throw new IllegalArgumentException("당첨 아이템의 수는 2개 이상이어야 합니다.");
        }
    }

    public WinningItem getByIndex(int index) {
        return winningItems.get(index);
    }

    public int count() {
        return winningItems.size();
    }

    public List<String> getWinningItemNames() {
        return winningItems.stream()
                .map(WinningItem::getName)
                .toList();
    }
}
