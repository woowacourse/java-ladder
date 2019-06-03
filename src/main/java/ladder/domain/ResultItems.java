package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class ResultItems {
    private List<LadderItem> ladderItems = new ArrayList<>();

    public ResultItems(List<String> itemNames, int numberOfPlayers) {
        if (itemNames.size() != numberOfPlayers) {
            throw new IllegalArgumentException("결과 항목의 수는 플레이어 수와 같아야합니다.");
        }
        for (String itemName : itemNames) {
            ladderItems.add(new LadderItem(itemName));
        }
    }

    public LadderItem getResultItemAtPositionOf(final int position) {
        return ladderItems.get(position);
    }

    public int size() {
        return ladderItems.size();
    }
}
