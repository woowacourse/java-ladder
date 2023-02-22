package ladder.domain;

import java.util.List;

public class Reward {
    private static final String OUT_OF_INDEX_ITEM_ERROR_MESSAGE = "해당 위치의 아이템은 존재하지 않습니다.";
    private final List<String> items;

    public Reward(final List<String> items) {
        this.items = items;
    }

    public String getRewardOf(final int i) {
        try {
            return items.get(i);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(OUT_OF_INDEX_ITEM_ERROR_MESSAGE, e);
        }
    }
}
