package ladder.domain;

import java.util.List;

public class Reward {
    private static final String OUT_OF_INDEX_ITEM_ERROR_MESSAGE = "해당 위치의 아이템은 존재하지 않습니다.";

    private final List<String> rewardItemsName;

    public Reward(final List<String> rewardItemsName) {
        this.rewardItemsName = rewardItemsName;
    }

    public String getRewardOf(final int i) {
        try {
            return rewardItemsName.get(i);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException(OUT_OF_INDEX_ITEM_ERROR_MESSAGE);
        }
    }

    public int size() {
        return rewardItemsName.size();
    }

    public List<String> getRewardItemsName() {
        return rewardItemsName;
    }
}
